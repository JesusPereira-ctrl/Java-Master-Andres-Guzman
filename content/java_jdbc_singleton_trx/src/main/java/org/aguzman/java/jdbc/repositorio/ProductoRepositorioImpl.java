package org.aguzman.java.jdbc.repositorio;

import org.aguzman.java.jdbc.modelo.Categoria;
import org.aguzman.java.jdbc.modelo.Producto;
import org.aguzman.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();

        try (
                Statement stmt = this.getConnection().createStatement();
                ResultSet rs = stmt.executeQuery("""
                        SELECT
                            a.*,
                            b.nombre as categoria
                        FROM
                            productos a
                        INNER JOIN categorias b ON
                            a.categoria_id = b.id
                        """)
        ) {
            while (rs.next()) {
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return productos;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;

        try (
                PreparedStatement stmt = this.getConnection()
                        .prepareStatement("""
                                SELECT
                                    a.*,
                                    b.nombre as categoria
                                FROM
                                    productos a
                                INNER JOIN categorias b ON
                                    a.categoria_id = b.id
                                WHERE
                                    a.id = ?
                                """);
        ) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearProducto(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;

        if (producto.getId() != null && producto.getId() > 0) {
            sql = """
                    UPDATE
                        productos
                    SET
                        nombre = ?,
                        precio = ?,
                        categoria_id = ?,
                        sku = ?
                    WHERE
                        id = ?
                    """;
        } else {
            sql = """
                    INSERT INTO
                        productos (nombre, precio, categoria_id, sku, fecha_registro)
                    VALUES
                        (?, ?, ?, ?, ?)
                    """;
        }

        try (PreparedStatement stmt = this.getConnection().prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());
            stmt.setString(4, producto.getSku());

            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(5, producto.getId());
            } else {
                stmt.setDate(5, new Date(producto.getFechaRegistro().getTime()));
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void eliminar(Long id) {
        try (
                PreparedStatement stmt = this.getConnection()
                        .prepareStatement("DELETE FROM productos WHERE id = ?")
        ) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    private static Producto crearProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        p.setSku(rs.getString("sku"));

        Categoria c = new Categoria();
        c.setId(rs.getLong("categoria_id"));
        c.setNombre(rs.getString("categoria"));

        p.setCategoria(c);

        return p;
    }
}
