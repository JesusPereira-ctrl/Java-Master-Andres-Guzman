package org.aguzman.app.jardin;

import org.aguzman.app.hogar.Persona;

public class EjemploPaquetes {
    public static void main(String[] args) {

        Persona p = new Persona();
        p.setNombre("Andrés");
        p.setApellido("Guzmán");
        System.out.println(p.getNombre());

        Perro perro = new Perro();
        perro.nombre = "Toby";
        perro.raza = "Bulldog";

        String jugando = perro.jugar(p);
        System.out.println("jugando = " + jugando);
    }
}
