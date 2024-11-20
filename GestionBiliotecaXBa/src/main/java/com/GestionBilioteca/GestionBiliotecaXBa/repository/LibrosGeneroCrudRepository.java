package com.GestionBilioteca.GestionBiliotecaXBa.repository;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.LibrosGenero;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.LibrosGeneroPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibrosGeneroCrudRepository extends CrudRepository<LibrosGenero, LibrosGeneroPK> {

    List<LibrosGenero> findByLibroIdLibro(Integer idLibro);
}
