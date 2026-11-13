package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.servicio.CatalogoServicio;
import org.aguzman.java.jdbc.servicio.Servicio;

import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();

        System.out.println("========== listar ==========");
        servicio.listar().forEach(System.out::println);

        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminación");

        Producto producto = new Producto();
        producto.setNombre("Lámpara LED de escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcdefgh12");

        System.out.println("========== guardando producto con categoria ==========");
        servicio.guardarProductoConCategoria(producto, categoria);
        System.out.println("Producto guardado éxitosamente con el id: " + producto.getId());
        System.out.println("Categoria guardada éxitosamente con el id: " + categoria.getId());

        System.out.println("========== listar ==========");
        servicio.listar().forEach(System.out::println);

    }
}
