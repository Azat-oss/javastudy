package ru.trop.stream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ru.trop.stream.Order;

public class StreamMain {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order("Alice", "Moscow", 1500.0, true,  List.of("Book", "Pen")),
                new Order("Bob",   "SPb",    3200.0, false, List.of("Laptop")),
                new Order("Alice", "Moscow", 800.0,  true,  List.of("Notebook")),
                new Order("Carol", "Kazan",  5000.0, true,  List.of("Phone", "Case", "Charger")),
                new Order("Bob",   "SPb",    1200.0, true,  List.of("Mouse")),
                new Order("Dave",  "Moscow", 250.0,  false, List.of("Pen", "Pencil"))
        );


        Order [] delivered = orders.stream()
                .filter(order -> order.isDelivered())
                .toArray(Order[]::new);

        System.out.println("Доставленные заказы: " + Arrays.toString(delivered));

        double totalDeliveredAmount = Arrays.stream(delivered)
                .mapToDouble(Order::getAmount)
                .sum();

        System.out.println("Сумма: " + totalDeliveredAmount);



    }


}
