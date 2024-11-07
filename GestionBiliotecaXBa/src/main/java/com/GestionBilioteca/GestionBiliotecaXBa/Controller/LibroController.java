package com.GestionBilioteca.GestionBiliotecaXBa.Controller;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.Genero;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.Libro;
import com.GestionBilioteca.GestionBiliotecaXBa.repository.LibroCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LibroController {

    @Autowired
    private LibroCrudRepository libroRepository;


    public List<Libro> listarLibros(){
        return (List<Libro>) libroRepository.findAll();
    }

    public List<Libro> listarLibrosGenero(List<Genero> generos){
        return libroRepository.findByGeneros_GeneroInOrderByNombreAsc(generos);
    }

    public  List<Libro> ListarStock(Integer stock ){
        return  libroRepository.findByStockLessThan(stock);
    }
}
