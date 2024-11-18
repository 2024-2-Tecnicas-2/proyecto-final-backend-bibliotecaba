package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "LibroPrestamo")
public class LibrosPrestamo {
    @EmbeddedId
    private LibrosPrestamoPK id;

    @ManyToOne
    @JoinColumn(name = "Libro_idLibro")
    private  Libro libro;

    @ManyToOne
    @JoinColumn(name = "Prestamo_idPrestamo")
    private  Prestamo prestamo;

}
