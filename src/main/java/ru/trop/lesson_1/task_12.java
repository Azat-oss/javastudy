package ru.trop.lesson_1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class task_12 {public static void main(String[] args){
    System.out.println("Task #12");
    Scanner scanner = new Scanner(System.in);
    try {
        System.out.println("Выберите метод сортировки массива: \n");

        int[] arr=new int[10];
        Random random = new Random();
        for (int i=0; i< arr.length;i++){
            arr[i]=random.nextInt(100)-50;
            System.out.print(arr[i]+" ");
        }
        System.out.println(" \n");

        System.out.println(" 1 - сортировка по возрастанию \n 2 - сортировка по убыванию ");
        System.out.println("Введите число 1 или 2 для продолжения...");
        int sort = scanner.nextInt();
        switch (sort){

            case 1:
                System.out.println(" Сортировка по возрастанию: \n ");

                for (int i=0; i<arr.length-1;i++){
                    for (int j=0; j<arr.length-i-1;j++){
                        if (arr[j]>arr[j+1]){
                            int tmp =arr[j];
                            arr[j]=arr[j+1];
                            arr[j+1]=tmp;
                        }
                    }
                }
                for (int x:arr){
                    System.out.print(x+" ");
                }
                break;

            case 2:
                System.out.println(" Сортировка по убыванию: \n ");
                int n =arr.length;

                for (int i=0; i<n-1;i++){
                    for (int j=0; j<n-i-1;j++){
                        if (arr[j]<arr[j+1]){
                            int tmp =arr[j];
                            arr[j]=arr[j+1];
                            arr[j+1]=tmp;
                        }
                    }
                }
                for (int x:arr){
                    System.out.print(x+" ");
                }
                break;
            default: System.out.println("Выберите 1 или 2");
        }
    }
    catch (InputMismatchException e){
        System.out.println("Неверный ввод!");
    }
    finally {
        scanner.close();
    }
}
}
