package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInventario;

    private Integer prestamos;

    @JoinColumn(name = "idLibro", insertable = false,updatable = false)
    private Libro libro;
}
