package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class LibrosPrestamoPK implements Serializable {
    @Column(name = "Libro_idLibro")
    private Integer idLibro;
    @Column(name = "Prestamo_idPrestamo")
    private Integer idPrestamo;

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
}
