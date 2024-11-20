package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "LibroGenero")
public class LibrosGenero {

    @EmbeddedId
    private LibrosGeneroPK id;

    @ManyToOne
    @JoinColumn(name = "Libro_idLibro", insertable = false,updatable = false)
    private Libro libro;


    @ManyToOne
    @JoinColumn(name = "Genero_genero",insertable = false,updatable = false)
    private Genero genero;

}
