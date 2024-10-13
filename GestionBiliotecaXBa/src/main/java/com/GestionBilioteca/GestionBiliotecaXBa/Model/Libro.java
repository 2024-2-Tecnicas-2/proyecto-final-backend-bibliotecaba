package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import java.util.ArrayList;
import java.util.Date;

public class Libro {
    String nombre;
    String autor;
    boolean estado;
    Date añoPublicacion;
    ArrayList<Genero> generos;

    public Libro(String nombre, String autor, boolean estado, Date añoPublicacion, ArrayList<Genero> generos) {
        this.nombre = nombre;
        this.autor = autor;
        this.estado = estado;
        this.añoPublicacion = añoPublicacion;
        this.generos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    public Date getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(Date añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
