package com.GestionBilioteca.GestionBiliotecaXBa.Model;


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
@Table(name = "Prestamo")
public class Prestamo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idPrestamo;
        private Date fecha;
        private Estudiante estudiante;
        private ArrayList<Libro> libros;


}
