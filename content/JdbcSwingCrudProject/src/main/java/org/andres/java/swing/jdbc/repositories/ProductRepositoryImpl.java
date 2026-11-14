package org.andres.java.swing.jdbc.repositories;

import org.andres.java.swing.jdbc.db.ConnectionJdbc;
import org.andres.java.swing.jdbc.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        try (
                Connection conn = ConnectionJdbc.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("""
                        SELECT
                            *
                        FROM
                            products;
                        """)
        ) {
            while (rs.next()) {
                Product product = createProduct(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return products;
    }

    @Override
    public Product findById(Long id) {
        Product product = null;

        try (
                Connection conn = ConnectionJdbc.getConnection();
                PreparedStatement stmt = conn.prepareStatement("""
                        SELECT
                            *
                        FROM
                            products
                        WHERE
                            id = ?;
                        """
                )
        ) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    product = createProduct(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return product;
    }

    @Override
    public Product save(Product product) {
        String sql;

        if (product.getId() != null && product.getId() > 0) {
            sql = """
                    UPDATE
                        products
                    SET
                        name = ?,
                        price = ?,
                        quantity = ?
                    WHERE
                        id = ?;
                    """;
        } else {
            sql = """
                    INSERT INTO
                        products (name, price, quantity)
                    VALUES (?, ?, ?);
                    """;
        }

        try (
                Connection conn = ConnectionJdbc.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getQuantity());

            if (product.getId() != null) {
                stmt.setLong(4, product.getId());
            }

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0 && (product.getId() == null || product.getId() == 0)) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        product.setId(rs.getLong(1));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return product;
    }

    @Override
    public void delete(Long id) {
        try (
                Connection conn = ConnectionJdbc.getConnection();
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM products WHERE id = ?;")
        ) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }

    private Product createProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getLong(0),
                rs.getString(1),
                rs.getInt(3),
                rs.getInt(4)
        );
    }
}
