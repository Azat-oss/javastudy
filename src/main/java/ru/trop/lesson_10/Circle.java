package ru.trop.lesson_10;

public class Circle extends Shape{

    private double radius;

    public Circle(double radius){
        if (radius<=0){
            throw new  IllegalArgumentException("Радиус должен быть положительным и не равным нулю");
        }
        this.radius=radius;
    }

    @Override
    public double getArea() {
        double area = Math.PI*radius*radius;
        return Math.round(area*100.0)/100.0;
    }

    @Override
    protected void displayInfo() {
        System.out.println("Площадь окружности радиусом "+radius +" равна: " +getArea());
    }
}
