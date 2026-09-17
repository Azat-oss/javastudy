package ru.trop.baza;

import java.math.BigDecimal;

public class Bazar {
    public static void main(String[] args) {

        Order order = new Order("Bob", true);
        Order order1= new Order("Petr", false);
        Order order2= new Order("Aida", true);

        order.display();
        order1.display();
        order2.display();



















    }
}
