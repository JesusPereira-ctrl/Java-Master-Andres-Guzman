package org.aguzman.archivos.ejemplos.servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoServicio {

    public void crearArchivo(String nombre) {
        File archivo = new File(nombre);
        try {
            FileWriter escritor = new FileWriter(archivo, true);
            escritor.append("Hola que tal amigos!\n")
                    .append("Todo bien? yo acá escribiendo un archivo...\n")
                    .append("Hasta luego Lucas!\n");
            escritor.close();
            System.out.println("El archivo se ha creado con éxito!");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
