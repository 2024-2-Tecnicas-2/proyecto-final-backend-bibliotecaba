package com.GestionBilioteca.GestionBiliotecaXBa.repository;

import com.GestionBilioteca.GestionBiliotecaXBa.Model.Prestamo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrestamoCrudRepository extends CrudRepository<Prestamo, Integer> {


    List<Prestamo> findByEstudianteIdEstudiante(Integer id);
}
