package org.aguzman.poointerfaces.imprenta;

import org.aguzman.poointerfaces.imprenta.modelo.*;

import static org.aguzman.poointerfaces.imprenta.modelo.Genero.PROGRAMACION;

public class EjemploImprenta {
    public static void main(String[] args) {

        Curriculo cv = new Curriculo(new Persona("John", "Doe"),
                "Ingeniero de sistemas", "Resumen laboral...");
        cv.addExperiencia("Java")
                .addExperiencia("Oracle DBA")
                .addExperiencia("Spring Framework")
                .addExperiencia("Desarrollador fullstack")
                .addExperiencia("Angular");

        Libro libro = new Libro(new Persona("Erich", "Gamma"),
                "Patrones de diseños: Elem. Reusables POO",
                PROGRAMACION);

        libro.addPagina(new Pagina("Patron Singleton"))
                .addPagina(new Pagina("Patron Observador"))
                .addPagina(new Pagina("Patron Factory"))
                .addPagina(new Pagina("Patron Composite"))
                .addPagina(new Pagina("Patron Facade"));

        Informe informe = new Informe(new Persona("Martin", "Fowler"),
                new Persona("James", "Gosling"), "Estudio sobre microservicios");

        imprimir(cv);
        imprimir(informe);
        imprimir(libro);
    }

    public static void imprimir(Imprimible imprimible) {
        System.out.println(imprimible.imprimir());
    }
}
