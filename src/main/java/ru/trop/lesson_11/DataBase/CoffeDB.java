package ru.trop.lesson_11.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

import ru.trop.lesson_11.model.Order;
import ru.trop.lesson_11.model.OrderItem;
import ru.trop.lesson_11.model.Product;
import ru.trop.lesson_11.model.User;

import java.time.LocalDate;
import java.util.Date;
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


    public static void createUser(Connection conn) throws SQLException {
        String sql = """
            CREATE TABLE users (
                id       NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                name     VARCHAR2(100) NOT NULL,
                age    Date NOT NULL,
                email     VARCHAR2(100),
                CONSTRAINT chk_email_at CHECK (email IS NULL OR email LIKE '%@%')
                            )""";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            if (e.getErrorCode() == 955) return; // уже есть — ок
            throw e;
        }
    }

    public static int insertUsers(Connection conn, User p) throws SQLException {
        String sql = "INSERT INTO users (name, age, email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, new String[]{"ID"})) {
            ps.setString(1, p.getName());
            ps.setDate(2, java.sql.Date.valueOf(p.getAge()));
            if (p.getEmail() != null) {
                ps.setString(3, p.getEmail());
            } else {
                ps.setNull(3, java.sql.Types.VARCHAR);   // ← явно NULL
            }
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    public static boolean isUsersEmpty(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) return rs.getInt(1) == 0;
        }
        return true;
    }

    public static List<User> getAllUsers(Connection conn) throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "SELECT id, name, age, email FROM USERS ORDER BY id";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("age").toLocalDate(),
                        rs.getString("email")
                ));
            }
        }
        return list;
    }

    public static User getYoungUser(Connection conn) throws SQLException {
        String sql = "SELECT id, name, age, email FROM users WHERE age = (SELECT MAX(age) FROM users)";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("age").toLocalDate(),
                        rs.getString("email")
                );
                System.out.println("Самый молодой: " + user);
                return user;
            }
        }
        System.out.println("Пользователи не найдены");
        return null;
    }

    public static User getOldUser(Connection conn) throws SQLException {
        String sql = "SELECT id, name, age, email FROM users WHERE age = (SELECT MIN(age) FROM users)";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                User user = new  User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("age").toLocalDate(),
                        rs.getString("email")
                );
                System.out.println("Самый старший: " + user);
                return user;
            }
        }
        System.out.println("Пользователи не найдены");
        return null;
    }

    public static User getUserEmailNull(Connection conn) throws SQLException {
        String sql = "SELECT id, name, age, email FROM users WHERE email IS NULL";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                User user = new  User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("age").toLocalDate(),
                        rs.getString("email")
                );
                System.out.println("Пользователь без email: " + user);
                return user;
            }
        }
        System.out.println("Пользователи не найдены");
        return null;
    }

    public static User getUserBirthDayToday(Connection conn) throws SQLException {
        String sql = """
                    SELECT id, name, age, email FROM users 
                    WHERE EXTRACT(MONTH FROM age) = EXTRACT(MONTH FROM SYSDATE)
                    AND EXTRACT(DAY FROM age) = EXTRACT(DAY FROM SYSDATE)
                """;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                User user = new  User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("age").toLocalDate(),
                        rs.getString("email")
                );
                System.out.println("С днем рожденья " + user.getName()+"!!!");
                return user;
            }
        }
        System.out.println("Пользователи не найдены");
        return null;
    }


    public static void createOrder(Connection conn) throws SQLException {
        String sql = """
            CREATE TABLE orders (
                id       NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                user_id  NUMBER NOT NULL,
                order_date    Date NOT NULL,
                CONSTRAINT fk_orders_user FOREIGN KEY (user_id) REFERENCES users(id)
                            )""";


        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица order создана.");
        } catch (SQLException e) {
            if (e.getErrorCode() == 955) return; // уже есть — ок
            throw e;
        }
    }

    public static void createOrderItems(Connection conn) throws SQLException {
        String sql = """
            CREATE TABLE orders_items (
                id       NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                order_id  NUMBER NOT NULL,
                product_id NUMBER NOT NULL,
                quantity   NUMBER NOT NULL CHECK (quantity > 0),
                CONSTRAINT fk_oi_order FOREIGN KEY (order_id) REFERENCES orders(id),
            CONSTRAINT fk_oi_product FOREIGN KEY (product_id) REFERENCES products(id)
                            )""";


        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Таблица order_items создана.");
        } catch (SQLException e) {
            if (e.getErrorCode() == 955) return; // уже есть — ок
            throw e;
        }
    }

    public static int insertOrder(Connection conn, int userId, LocalDate orderDate) throws SQLException {
        String sql = "INSERT INTO orders (user_id, order_date) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, new String[]{"ID"})) {
            ps.setInt(1, userId);
            ps.setDate(2, java.sql.Date.valueOf(orderDate));
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public static void insertOrderItem(Connection conn, int orderId, int productId, int quantity) throws SQLException {
        String sql = "INSERT INTO orders_items (order_id, product_id, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        }
    }

    public static Order getOrderWithItems(Connection conn, int orderId) throws SQLException {
        String sql = """
            SELECT o.id, o.user_id, o.order_date,
                   oi.id AS item_id, oi.product_id, oi.quantity,
                   p.name AS product_name, p.price AS product_price
            FROM orders o
            LEFT JOIN orders_items oi ON o.id = oi.order_id
            LEFT JOIN products p ON oi.product_id = p.id
            WHERE o.id = ?
            """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                Order order = null;
                List<OrderItem> items = new ArrayList<>();

                while (rs.next()) {

                    if (order == null) {
                        order = new Order(
                                rs.getInt("id"),
                                rs.getInt("user_id"),
                                rs.getDate("order_date").toLocalDate(),
                                items
                        );
                    }


                    if (rs.getString("product_name") != null) {
                        OrderItem item = new OrderItem();
                        item.setId(rs.getInt("item_id"));
                        item.setOrderId(rs.getInt("id"));
                        item.setProductId(rs.getInt("product_id"));
                        item.setQuantity(rs.getInt("quantity"));
                        items.add(item);
                    }
                }
                return order;
            }
        }
    }

    public static List<Order> getAllOrders(Connection conn) throws SQLException {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT id, user_id, order_date FROM orders ORDER BY id";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Order(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getDate("order_date").toLocalDate(),
                        new ArrayList<>()
                ));
            }
        }
        return list;
    }





}
