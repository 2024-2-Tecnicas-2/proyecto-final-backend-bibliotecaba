package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class LibrosGeneroPK implements Serializable {
    @Column(name = "Libro_idLibro")
    private  Integer idLibro;
    @Column(name = "Genero_genero")
    private  Integer idGenero;

    public Integer getIdLibro() {
        return idLibro;
    }
    
    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }
}
