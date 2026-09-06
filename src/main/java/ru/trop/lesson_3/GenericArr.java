package ru.trop.lesson_3;
import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GenericArr <T extends Comparable<T>>{
   private final Object[] arr;
   private final Class<T> type;

   public GenericArr(Class<T> type, int size){
       if (size<=0){
           throw new IllegalArgumentException("Размер массива не должен быть отрицательным");
       }
       this.type=type;
       this.arr= new Object[size];
   }

   public void InsertConsole() {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Введите " + arr.length + " элементов:");

       for (int i = 0; i < arr.length; i++) {

           while (true) {
               try {
                   if (type == Integer.class) {
                       arr[i] = scanner.nextInt();
                       break;

                   } else if (type == Double.class) {
                       arr[i] = scanner.nextDouble();
                       break;

                   } else if (type == String.class) {

                       arr[i] = scanner.next();
                       break;

                   } else {
                       throw new UnsupportedOperationException("Неверный тип");
                   }

               } catch (InputMismatchException e) {
                   System.out.print("Неверный тип");
                   scanner.next();
               }
           }
       }
   }

    public void print() {
        System.out.println(Arrays.toString(arr));
    }

    public T getMin() {
        if (arr.length == 0) {
            throw new IllegalStateException("Массив пуст");
        }

        T min = type.cast(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            T cur = type.cast(arr[i]);
            if (cur.compareTo(min) < 0) {
                min = cur;
            }
        }
        return min;
    }

    public T getMax() {
        if (arr.length == 0) {
            throw new IllegalStateException("Массив пуст");
        }

        T max = type.cast(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            T cur = type.cast(arr[i]);
            if (cur.compareTo(max) > 0) {
                max = cur;
            }
        }
        return max;
    }

}




