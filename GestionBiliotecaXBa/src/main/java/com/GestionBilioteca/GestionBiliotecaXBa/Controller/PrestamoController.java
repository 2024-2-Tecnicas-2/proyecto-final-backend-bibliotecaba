package com.GestionBilioteca.GestionBiliotecaXBa.Controller;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.Inventario;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.Libro;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.Prestamo;
import com.GestionBilioteca.GestionBiliotecaXBa.exception.ResourceNotFoundException;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.InventarioCrudRepository;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.LibroCrudRepository;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.PrestamoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PrestamoController {

    @Autowired
    private PrestamoCrudRepository prestamoCrudRepository;

    @Autowired
    private LibroCrudRepository libroCrudRepository;

    @Autowired
    private InventarioCrudRepository inventarioCrudRepository;

    @PostMapping("/prestamos")
    public Prestamo guardarPrestamos(@RequestBody Prestamo prestamo){
         return prestamoCrudRepository.save(prestamo);
    }


    @GetMapping("/prestamos")
    public List<Prestamo> listarPrestamos(){
        return (List<Prestamo>) prestamoCrudRepository.findAll();

    }

    @GetMapping("/prestamos/{id}")
    public List<Prestamo> listarPrestamosId(@PathVariable Integer id){
       return  prestamoCrudRepository.findByEstudianteIdEstudiante(id);
    }

    @DeleteMapping("/prestamos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminar(@PathVariable Integer id){
        Prestamo prestamo=prestamoCrudRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El prestamo con ese id no existe "+ id));
        prestamoCrudRepository.delete(prestamo);
        Map<String,Boolean> response =new HashMap<>();
        response.put("deleted" ,Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



    @PostMapping("/prestamos/{id}")
    public ResponseEntity<String> prestarLibro(@PathVariable Integer idLibro) {

        Libro libro = libroCrudRepository.findById(idLibro)
                .orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado con id: " +idLibro ));

        // Verificar si hay stock disponible
        if (libro.getStock() <= 0) {
            return ResponseEntity.badRequest().body("El libro no está disponible (stock insuficiente)");
        }
        Prestamo prestamo =new Prestamo();
        prestamo.setFecha(new Date());
        prestamoCrudRepository.save(prestamo);

        libro.setStock(libro.getStock() - 1);
        libroCrudRepository.save(libro);

        Inventario inventario =new Inventario();
        
        inventario.setPrestamos(inventario.getPrestamos()+1);

        return ResponseEntity.ok("Préstamo realizado con éxito.");
    }



}
