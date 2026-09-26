package ru.trop.lesson_11.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private int userId;
    private LocalDate orderDate;
    private List<OrderItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(int id, int userId, LocalDate orderDate, List<OrderItem> items) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderDate=" + orderDate +
                ", items=" + items +
                '}';
    }
}
