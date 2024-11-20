package com.GestionBilioteca.GestionBiliotecaXBa.Controller;


import com.GestionBilioteca.GestionBiliotecaXBa.Model.Genero;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.Libro;
import com.GestionBilioteca.GestionBiliotecaXBa.exception.ResourceNotFoundException;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.GeneroCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class GeneroController {

    @Autowired
    private GeneroCrudRepository generoCrudRepository;

    @GetMapping("/Generos")
    public List<Genero> listarGenero(){
        return (List<Genero>) generoCrudRepository.findAll();

    }

    @PostMapping("/Generos")
    public Genero guardarGenero(@RequestBody Genero genero){
        return generoCrudRepository.save(genero);
    }


    @DeleteMapping("/Generos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminar(@PathVariable Integer id){
        Genero genero =generoCrudRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El genero con ese id no existe "+ id));
        generoCrudRepository.delete(genero);
        Map<String,Boolean> response =new HashMap<>();
        response.put("deleted" ,Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
