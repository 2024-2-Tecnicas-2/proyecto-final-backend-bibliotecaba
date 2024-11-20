package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  idGenero;

    private String genero;

    //relacion
    @OneToMany(mappedBy = "genero")
    private List<LibrosGenero> librosGeneros;
}
