package com.GestionBilioteca.GestionBiliotecaXBa.Controller;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.Libro;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.Prestamo;
import com.GestionBilioteca.GestionBiliotecaXBa.exception.ResourceNotFoundException;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.PrestamoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PrestamoController {

    @Autowired
    private PrestamoCrudRepository prestamoCrudRepository;

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


}
