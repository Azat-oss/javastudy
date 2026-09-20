package ru.trop.lesson_11;
import ru.trop.lesson_11.DataBase.CoffeDB;
import ru.trop.lesson_11.model.Product;
import java.sql.Connection;
import java.util.List;

public class CoffeeShop {
    public static void main(String[] args) {
        try (Connection conn = CoffeDB.getConnection()) {

            CoffeDB.createTable(conn);
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

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
