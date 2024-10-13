package com.GestionBilioteca.GestionBiliotecaXBa.Model;

import java.util.ArrayList;
import java.util.Date;

public class Estudiante {

    String nombre;
    int codigo;
    ArrayList<Prestamo> prestamos;

    public Estudiante(String nombre, ArrayList<Prestamo> prestamos, int codigo) {
        this.nombre = nombre;
        this.prestamos = prestamos;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }
}
