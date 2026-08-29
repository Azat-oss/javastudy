package ru.trop.lesson_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class task_7 {
    public static void main (String[] args){
        System.out.println("Task #7");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vvedite 1-e celoe chislo");
        int a;
        try {
            a = scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Error# Vvedeno ne celoe chislo.");
            return;
        }

        System.out.println("Vvedite 2-e celoe chislo");
        int b;
        try {
            b = scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Error# Vvedeno ne celoe chislo.");
            return;
        }

        int min = Math.min(a,b);
        int max = Math.max(a,b);

        System.out.println("привет Nechetnye chisla ot "+ min + " do " + max);

        for (int i= min; i<= max; i++ )
        {
            if (i%2!=0){
                System.out.print(i+ " ");
            }
        }

        scanner.close();
    }
}
