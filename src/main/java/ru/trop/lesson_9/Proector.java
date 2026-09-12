package ru.trop.lesson_9;

import java.time.LocalDate;

public class Proector {
    String name;
    LocalDate yearProdaction;
    Double price;
    String nameFactory;

    public Proector(String name, LocalDate yearProdaction, Double price, String nameFactory){
        this.name=name;
        this.yearProdaction=yearProdaction;
        this.price=price;
        this.nameFactory=nameFactory;

    }

    public String getName() {
        return name;
    }

    public LocalDate getYearProdaction() {
        return yearProdaction;
    }

    public Double getPrice() {
        return price;
    }

    public String getNameFactory() {
        return nameFactory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearProdaction(LocalDate yearProdaction) {
        this.yearProdaction = yearProdaction;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setNameFactory(String nameFactory) {
        this.nameFactory = nameFactory;
    }

    @Override
    public String toString() {
        return "Проекторы {" +
                "Наименование: " + name + '\'' +
                ", Дата выпуска: " + yearProdaction +
                ", Цена: " + price +
                ", Производитель: " + nameFactory + '\'' +
                '}';
    }
}
