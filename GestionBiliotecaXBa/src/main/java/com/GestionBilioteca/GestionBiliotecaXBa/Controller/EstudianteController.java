package com.GestionBilioteca.GestionBiliotecaXBa.Controller;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.Estudiante;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.Libro;
import com.GestionBilioteca.GestionBiliotecaXBa.exception.ResourceNotFoundException;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.EstudianteCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EstudianteController {
    @Autowired
    private EstudianteCrudRepository estudianteCrudRepository;

    @GetMapping("/estudiantes")
    public List<Estudiante> listarEstudiantes(){
                 return (List<Estudiante>) estudianteCrudRepository.findAll();
    }

    @PostMapping("/estudiantes")
    public Estudiante guardarEstudiante(@RequestBody Estudiante estudiante){
        return estudianteCrudRepository.save(estudiante);
    }

    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEstudiante(@PathVariable Integer id){
        Estudiante estudiante =estudianteCrudRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El esudiante con ese id no existe "+ id));
        estudianteCrudRepository.delete(estudiante);
        Map<String,Boolean> response =new HashMap<>();
        response.put("deleted" ,Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiante> ActualizarLibr(@PathVariable Integer id,@RequestBody Estudiante estudianteRequest){
        Estudiante estudiante =estudianteCrudRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El estudiante con ese id no existe "+ id));

        estudiante.setNombre(estudianteRequest.getNombre());
        estudiante.setCodigo(estudianteRequest.getCodigo());
        estudiante.setPrestamos(estudianteRequest.getPrestamos());

        Estudiante estudianteActualizado=estudianteCrudRepository.save(estudiante);

        return ResponseEntity.ok(estudianteActualizado);
    }

}
