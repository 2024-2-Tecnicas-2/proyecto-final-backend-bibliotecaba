package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "LibroPrestamo")
public class LibrosPrestamo {
    @EmbeddedId
    private LibrosPrestamoPK id;
}
