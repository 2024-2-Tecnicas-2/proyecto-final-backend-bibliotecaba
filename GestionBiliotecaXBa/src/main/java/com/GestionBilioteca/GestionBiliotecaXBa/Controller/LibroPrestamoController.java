package com.GestionBilioteca.GestionBiliotecaXBa.Controller;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.LibrosPrestamo;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.EstudianteCrudRepository;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.InventarioCrudRepository;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.LibroCrudRepository;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.LibroPrestamoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5173")
public class LibroPrestamoController  {

    @Autowired
    private LibroPrestamoCrudRepository libroPrestamoCrudRepository;

    @Autowired
    private LibroCrudRepository libroRepository;

    @Autowired
    private EstudianteCrudRepository estudianteCrudRepository;

    @Autowired
    private InventarioCrudRepository inventarioCrudRepository;

    @Autowired
    private  LibroController libroController;

    @GetMapping("/prestar")
    public List<LibrosPrestamo> listarPrestamos(){
       return (List<LibrosPrestamo>) libroPrestamoCrudRepository.findAll();

    }

    @PostMapping("/prestar")
    public LibrosPrestamo guardarLibroPrestamo(@RequestBody LibrosPrestamo librosPrestamo){
        return libroPrestamoCrudRepository.save(librosPrestamo);
    }


}
