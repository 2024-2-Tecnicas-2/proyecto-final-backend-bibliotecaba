package com.GestionBilioteca.GestionBiliotecaXBa.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Blob;
import java.util.Date;
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
    private Date year;
    private Integer stock;
    private Blob imagen;

    @OneToOne(mappedBy = "libro",cascade =CascadeType.ALL )
    private Inventario inventario;

    @OneToMany(mappedBy = "libro")
    private List<LibrosGenero> generos;

}
