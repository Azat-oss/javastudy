package ru.trop.stream;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customer;
    private String city;
    private double amount;
    private boolean delivered;
    private List<String> items;

    public Order(String customer, String city, double amount, boolean delivered, List<String>items){
        this.customer=customer;
        this.city=city;
        this.amount=amount;
        this.delivered=delivered;
        this.items=new ArrayList<>();

    }

    public String getCustomer(){return customer;}

    public double getAmount() {
        return amount;
    }

    public boolean isDelivered() {
        return delivered;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer='" + customer + '\'' +
                ", city='" + city + '\'' +
                ", amount=" + amount +
                ", delivered=" + delivered +
                ", items=" + items +
                '}';
    }
}
