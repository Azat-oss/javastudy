package ru.trop.lesson_11.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import ru.trop.lesson_11.model.Product;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class CoffeDB {

    private static final String URL  = "jdbc:oracle:thin:@//localhost:1521/XE";
    private static final String USER = "azart";
    private static final String PASS = "azart123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void createTable(Connection conn) throws SQLException {
        String sql = """
            CREATE TABLE products (
                id       NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                name     VARCHAR2(100) NOT NULL,
                price    NUMBER(10,2) NOT NULL,
                quantity NUMBER DEFAULT 0 NOT NULL
            )
            """;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            if (e.getErrorCode() == 955) return; // уже есть — ок
            throw e;
        }
    }


    public static List<Product> getAll(Connection conn) throws SQLException {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT id, name, price, quantity FROM products ORDER BY id";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("quantity")
                ));
            }
        }
        return list;
    }

    public static int insert(Connection conn, Product p) throws SQLException {
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, new String[]{"ID"})) {
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, p.getQuantity());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    public static boolean isEmpty(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(*) FROM products";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) return rs.getInt(1) == 0;
        }
        return true;
    }



}
