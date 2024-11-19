package com.GestionBilioteca.GestionBiliotecaXBa.repository;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.Genero;
import com.GestionBilioteca.GestionBiliotecaXBa.Model.Inventario;
import org.springframework.data.repository.CrudRepository;

public interface GeneroCrudRepository extends CrudRepository<Genero, Integer> {
}
