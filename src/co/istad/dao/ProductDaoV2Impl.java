package co.istad.dao;

import co.istad.model.Product;
import co.istad.util.DbSingleton;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDaoV2Impl implements ProductDao {

    private final Connection connection;

    public ProductDaoV2Impl() {
        this.connection = DbSingleton.instance();
    }

    @Override
    public Product insert(Product product) {
        String sql = """
                INSERT INTO products(name, qty, price, imported_date, category_id)
                VALUES(?, ?, ?, ?, ?)
                RETURNING ID
                """;
        try {
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setLong(2, product.getQty());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setDate(4, new Date(System.currentTimeMillis()));
            pstmt.setInt(5, 2);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Long generatedKey = rs.getLong("id");
            return this.selectById(generatedKey).orElseThrow();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> select() {
        String sql = "SELECT * FROM products";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setQty(rs.getInt("qty"));
                product.setPrice(rs.getDouble("price"));
                product.setImportedDate(rs.getDate("imported_date").toLocalDate());
                products.add(product);
            }

            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Product> selectById(Long id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            Product product = new Product();
            while (rs.next()) {
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setQty(rs.getInt("qty"));
                product.setPrice(rs.getDouble("price"));
                product.setImportedDate(rs.getDate("imported_date").toLocalDate());
            }

            return Optional.of(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product updateById(Product product) {
        return null;
    }

    @Override
    public Product deleteById(Long id) {
        return null;
    }

    @Override
    public List<Product> selectByName(String name) {
        return null;
    }
}
