package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import com.mysql.cj.jdbc.Blob;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLibro;
    private String nombre;
    private String autor;
    private Date year;
    private Integer stock;
    private Blob imagen;
    private ArrayList<Genero> generos;
}
