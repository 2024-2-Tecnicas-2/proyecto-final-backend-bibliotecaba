package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

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
    private LocalDate year;
    private Integer stock;

    @Lob
    private byte[] imagen;

    @OneToOne(mappedBy = "libro",cascade =CascadeType.ALL )
    private Inventario inventario;

    @OneToMany(mappedBy = "libro")
    private List<LibrosGenero> Librosgenero;

}
