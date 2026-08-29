package ru.trop.lesson_1;

import java.util.Scanner;

public class task_3 {
    public static void main(String[] args){

        System.out.println("Task #3");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vvedite 1-e celoe chislo ot 0 do 9:");
        int a = scanner.nextInt();
        System.out.println("Vvedite 2-e celoe chislo 0 do 9:");
        int b = scanner.nextInt();
        System.out.println("Vvedite 3-e celoe chislo 0 do 9:");
        int c = scanner.nextInt();

        int d =a*100+b*10+c;
        System.out.println(d);

        scanner.close();

    }
}
