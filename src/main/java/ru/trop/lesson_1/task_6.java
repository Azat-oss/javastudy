package ru.trop.lesson_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task_6 {
    public static void main (String[] args){
        System.out.println("Task #6");
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Vvedite chislo dly perevoda (Example:45,12):");
            double a = scanner.nextDouble();

            System.out.println(" 1 - meter \n 2 - inch \n 3 - yard ");
            System.out.println("Vyberite 1, 2 or 3 dly perevoda:");


            int unit = scanner.nextInt();
            switch (unit) {
                case 1:
                    System.out.println(a + "m");
                    break;
                case 2:
                    double d = a * 39.37;
                    System.out.printf("%.2f inch%n", d);
                    break;
                case 3:
                    double yard = a * 1.09;
                    System.out.printf("%.2f yard%n", yard);
                    break;

                default: System.out.println("Error$ Vvedite celoe chislo 1-3");
            }

        }
        catch (InputMismatchException e){
            System.out.println("Error# Vvedeno ne chislo.");

        }

        finally {
                scanner.close();
        }

    }
}
