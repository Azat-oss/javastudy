package ru.trop.lesson_1;

import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {

        //Задание №2
        System.out.println("Task #2");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vvedite chislo:");
        double a = scanner.nextDouble();

        System.out.println("Vvedite chislo - opredelenie procenta:");
        double b =scanner.nextDouble();
        double c =(a*b)/100.0;
        System.out.println(b+" % chisla "+a+":");
        System.out.println(c);
        System.out.printf("%.2f%n", c);

        scanner.close();
    }

}
