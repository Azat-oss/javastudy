package ru.trop.lesson_11;
import ru.trop.lesson_11.DataBase.CoffeDB;
import ru.trop.lesson_11.model.Product;
import ru.trop.lesson_11.model.User;
import ru.trop.lesson_11.model.Order;
import ru.trop.lesson_11.model.OrderItem;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class CoffeeShop {
    public static void main(String[] args) {
        try (Connection conn = CoffeDB.getConnection()) {

            CoffeDB.createTable(conn);
            CoffeDB.createOrder(conn);
            CoffeDB.createOrderItems(conn);

            System.out.println("Таблица создана ✓");

            if (CoffeDB.isEmpty(conn)) {
                CoffeDB.insert(conn, new Product(0, "Эспрессо",  120.00, 50));
                CoffeDB.insert(conn, new Product(0, "Капучино",   220.00, 40));
                CoffeDB.insert(conn, new Product(0, "Латте",      250.00, 35));
                CoffeDB.insert(conn, new Product(0, "Раф",        280.00, 30));
                CoffeDB.insert(conn, new Product(0, "Чизкейк",    300.00, 15));
                System.out.println("Данные добавлены ✓");
            } else {
                System.out.println("Данные уже есть ✓");
            }


            List<Product> products = CoffeDB.getAll(conn);
            for (Product p : products) {
                System.out.println(p);
            }

            CoffeDB.createUser(conn);
            System.out.println("Таблица пользователей создана ✓");

            if (CoffeDB.isUsersEmpty(conn)) {
                CoffeDB.insertUsers(conn, new User(0,"Том", LocalDate.of(2013,1,1),"tom@mail.ru"));
                CoffeDB.insertUsers(conn, new User(0,"Светлана", LocalDate.of(2009,5,15),"tompof@mail.ru"));
                CoffeDB.insertUsers(conn, new User(0,"Семен", LocalDate.of(2000,7,22),"semeb@mail.ru"));
                CoffeDB.insertUsers(conn, new User(0,"Лариса", LocalDate.of(1958,9,22),"tynv@mail.ru"));
                CoffeDB.insertUsers(conn,new User(0,"Иван",LocalDate.of(1960,3,8)));

                System.out.println("Пользователи добавлены ✓");
            } else {
                System.out.println("Данные пользователи уже есть ✓");
            }

            List<User> users = CoffeDB.getAllUsers(conn);
            for (User user : users) {
                System.out.println(user);
            }

            User youngUser = CoffeDB.getYoungUser(conn);
            User oldUser = CoffeDB.getOldUser(conn);

            User userEmailNull =CoffeDB.getUserEmailNull(conn);
            User userBirthDay =CoffeDB.getUserBirthDayToday(conn);

            // урок 12 Создание заказов

            List<User> users2 = CoffeDB.getAllUsers(conn);
            int userId = users2.get(0).getId();

            List<Product> products2 = CoffeDB.getAll(conn);
            int productId = products2.get(0).getId();
            int quantity = 2;

            int orderId = CoffeDB.insertOrder(conn, userId, LocalDate.now());
            System.out.println("Заказ создан: №" + orderId);

            CoffeDB.insertOrderItem(conn, orderId, productId, quantity);
            System.out.println("Товар добавлен в заказ");

            Order order = CoffeDB.getOrderWithItems(conn, orderId);
            System.out.println("Заказ: " + order);

            List<Order> allOrders = CoffeDB.getAllOrders(conn);
            System.out.println("\nВсе заказы:");
            for (Order o : allOrders) {
                System.out.println(o);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }








    }
}
