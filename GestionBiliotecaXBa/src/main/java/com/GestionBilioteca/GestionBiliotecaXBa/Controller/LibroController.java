package com.GestionBilioteca.GestionBiliotecaXBa.Controller;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.Libro;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;


    private List<Libro> listarLibros(){
        return null ;
    }
}
