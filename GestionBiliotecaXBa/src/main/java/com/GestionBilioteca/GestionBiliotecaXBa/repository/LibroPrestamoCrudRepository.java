package com.GestionBilioteca.GestionBiliotecaXBa.repository;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.Libro;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.LibrosPrestamo;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.LibrosPrestamoPK;
import org.springframework.data.repository.CrudRepository;

public interface LibroPrestamoCrudRepository extends CrudRepository<LibrosPrestamo, LibrosPrestamoPK> {


}
