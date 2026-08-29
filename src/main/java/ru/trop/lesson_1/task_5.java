package ru.trop.lesson_1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class task_5 {
    public static void main(String[] args){
        System.out.println("Task #5");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vvedite celoe chislo ot 0 do 12:");

        try {
            int month = scanner.nextInt();
            switch (month){
                case 1,2,12:
                    System.out.println("Winter");
                    break;
                case 3,4,5:
                    System.out.println("Spring");
                    break;
                case 6,7,8:
                    System.out.println("Summer");
                    break;
                case 9,10,11:
                    System.out.println("Autumm");
                    break;
                default: System.out.println("Error$ Vvedite celoe chislo 1-12");
            }

        }
        catch (InputMismatchException e){
            System.out.println("Error# Vvedeno ne celoe chislo");
        }

        finally {
            scanner.close();
        }
    }
}
