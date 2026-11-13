package org.aguzman.java.jdbc;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.aguzman.java.jdbc.repositorio.Repositorio;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = ConexionBaseDatos.getConnection()) {
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }

            try {

                Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conn);
                Repositorio<Producto> repositorioProducto = new ProductoRepositorioImpl(conn);

                System.out.println("========== insertar nueva categoria ==========");
                Categoria categoria = new Categoria();
                categoria.setNombre("Electro hogar");
                Categoria nuevaCategoria = repositorioCategoria.guardar(categoria);
                System.out.println("Categoria guardada éxitosamente con el id: " + nuevaCategoria.getId());

                System.out.println("========== listar ==========");
                repositorioProducto.listar().forEach(System.out::println);

                System.out.println("========== obtener por id ==========");
                System.out.println(repositorioProducto.porId(1L));

                System.out.println("========== insertar nuevo producto ==========");
                Producto producto = new Producto();
                producto.setNombre("Refrigerador Samsung");
                producto.setPrecio(9900);
                producto.setFechaRegistro(new Date());
                producto.setSku("abcdefg123");

                producto.setCategoria(nuevaCategoria);
                repositorioProducto.guardar(producto);
                System.out.println("Producto guardado éxitosamente con el id: " + producto.getId());

                System.out.println("========== listar ==========");
                repositorioProducto.listar().forEach(System.out::println);

                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
                conn.rollback();
            }
        }
    }
}
