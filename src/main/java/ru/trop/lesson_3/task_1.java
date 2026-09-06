package ru.trop.lesson_3;
import java.util.InputMismatchException;
import java.util.Scanner;

public class task_1 { public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите размер массива:");
    int count ;
    try {
        count = scanner.nextInt();
        if (count<=0){
            System.out.println("Ошибка: размер массива должен быть положительным целым числом");
            return;
        }

        GenericArr<Integer> arr = new GenericArr<>(Integer.class, count);
        arr.InsertConsole();
        arr.print();

        System.out.println("Минимум: " + arr.getMin());
        System.out.println("Максимум: " + arr.getMax());


        GenericArr<String> arr2 = new GenericArr<>(String.class, count);
        arr2.InsertConsole();
        arr2.print();

        System.out.println("Минимум: " + arr2.getMin());
        System.out.println("Максимум: " + arr2.getMax());

    }
    catch (InputMismatchException e){

        System.out.println("Ошибка: размер массива должен быть целым числом");
        return;
    }

}
}
