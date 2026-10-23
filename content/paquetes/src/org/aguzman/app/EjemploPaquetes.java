package org.aguzman.app;

import org.aguzman.app.hogar.Persona;

public class EjemploPaquetes {
    public static void main(String[] args) {

        Persona p = new Persona();
        p.nombre = "Andrés";
        System.out.println(p.nombre);

        Perro perro = new Perro();
        perro.nombre = "Toby";
        perro.raza = "Bulldog";
    }
}
