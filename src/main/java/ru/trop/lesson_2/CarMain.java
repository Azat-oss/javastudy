package ru.trop.lesson_2;

public class CarMain {public static void main(String[] args) {

    Car car1 =new Car("ВАЗ 2107",2002,"АвтоВАЗ", 80);
    car1.PrintInfo();

    Car car2= new Car("Mitsubishi Coil",2007);
    car2.PrintInfo();

    car2.setName("Mitsubishi Colt");
    car2.PrintInfo();

}
}
