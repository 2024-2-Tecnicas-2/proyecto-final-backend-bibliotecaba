package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "LibroGenero")
public class LibrosGenero {

    private LibrosGeneroPK id;
}
