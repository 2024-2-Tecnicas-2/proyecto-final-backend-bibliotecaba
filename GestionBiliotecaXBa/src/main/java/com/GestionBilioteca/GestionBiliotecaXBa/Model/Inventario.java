package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {
    private Integer idInventario;
    private Integer prestamos;

    @OneToOne
    private Libro libro;
}
