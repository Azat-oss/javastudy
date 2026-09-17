package ru.trop.baza;

public class Order {
    private String name;
    private boolean delivery;

    public Order(String name, boolean delivery){
        this.name=name;
        this.delivery =delivery;

    }

    public String getName() {
        return name;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public void display(){
        if (delivery){
            System.out.println("Заказ доставлен для " +name);
        }
        else {
            System.out.println("Заказ не доставлен для " +name);
        }

    }



}
