package com.GestionBilioteca.GestionBiliotecaXBa.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        @ManyToOne
        @JoinColumn(name = "Estudiante_idEstudiante",insertable = false,updatable = false)
        private Estudiante estudiante;

        @OneToMany(mappedBy = "prestamo")
        private List<LibrosPrestamo> prestamos;


}
