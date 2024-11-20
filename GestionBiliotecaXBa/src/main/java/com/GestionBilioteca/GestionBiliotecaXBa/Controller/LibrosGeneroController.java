package com.GestionBilioteca.GestionBiliotecaXBa.Controller;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.Genero;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.Libro;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.LibrosGenero;
import com.GestionBilioteca.GestionBiliotecaXBa.exception.ResourceNotFoundException;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.GeneroCrudRepository;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.LibroCrudRepository;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.LibrosGeneroCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class LibrosGeneroController {

    @Autowired
    private LibroCrudRepository   libroCrudRepository;
    @Autowired
    private GeneroCrudRepository  generoCrudRepository;
    @Autowired
    private LibrosGeneroCrudRepository librosGeneroCrudRepository;

    @PostMapping("/generos/{idLibro}")
    public ResponseEntity<Libro> asignarGeneros(@PathVariable Integer idLibro, @RequestBody List<Integer> generosIds) {

        Libro libro = libroCrudRepository.findById(idLibro)
                .orElseThrow(() -> new ResourceNotFoundException("El libro con ese id no existe: " + idLibro));

        for (Integer generoId : generosIds) {
            Genero genero = generoCrudRepository.findById(generoId)
                    .orElseThrow(() -> new ResourceNotFoundException("Género con id " + generoId + " no encontrado"));
            LibrosGenero librosGenero = new LibrosGenero();
            librosGenero.setLibro(libro);
            librosGenero.setGenero(genero);
                        librosGeneroCrudRepository.save(librosGenero);
        }
        return ResponseEntity.ok(libro);
    }

    @GetMapping("/generos/{idLibro}")
    public List<LibrosGenero> librosGeneros(@PathVariable Integer idLibro ){
        return  librosGeneroCrudRepository.findByLibroIdLibro(idLibro);
    }

}
