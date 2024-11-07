package com.GestionBilioteca.GestionBiliotecaXBa.repository;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.Genero;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.Libro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LibroCrudRepository extends CrudRepository<Libro, Integer> {

    //listar libros por genero
    List<Libro>  findByGeneros_GeneroInOrderByNombreAsc(List<Genero> generos);
    List<Libro> findByStockLessThan(Integer stock );




}
