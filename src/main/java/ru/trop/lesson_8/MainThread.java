package ru.trop.lesson_8;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainThread {

    static int[] arr = new int[10];
    static boolean isFilled = false;
    static final Lock lock = new ReentrantLock();
    static final Condition arrayFilled = lock.newCondition();

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            long threadStart = System.nanoTime();

            lock.lock();
            try {
                System.out.print("Заполнение массива: \n");

                Random random = new Random();

                for (int i = 0; i < arr.length; i++) {
                    arr[i] = random.nextInt(100) - 50;
                    System.out.print(arr[i] + " ");
                }
                System.out.println();

                isFilled = true;
                arrayFilled.signalAll();

            } finally {
                lock.unlock();
            }

            long threadEnd = System.nanoTime();
            System.out.println("Время работы Потока №1: " + (threadEnd - threadStart)/1000 + " мкс");


        });

        Thread sumConsumer = new Thread(() -> {
            long threadStart = System.nanoTime();
            lock.lock();
            try {
                while (!isFilled) {
                    System.out.println("Ожидание заполнения массива...");
                    arrayFilled.await();
                }

                int sum = 0;
                for (int num : arr) {
                    sum += num;
                }
                System.out.println("Сумма элементов: " + sum);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            long threadEnd = System.nanoTime();
            System.out.println("Время работы Потока №2: " + (threadEnd - threadStart)/1000 + " мкс");
        });

        Thread avgConsumer = new Thread(() -> {
            long threadStart = System.nanoTime();
            lock.lock();
            try {
                while (!isFilled) {
                    System.out.println("Ожидание заполнения массива...");
                    arrayFilled.await();
                }

                double sum = 0;
                for (int num : arr) {
                    sum += num;
                }
                System.out.println("Среднее арифметическое: " + (sum / arr.length));

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            long threadEnd = System.nanoTime();
            System.out.println("Время работы Потока №3: " + (threadEnd - threadStart)/1000 + " мкс");

        });

        producer.start();
        sumConsumer.start();
        avgConsumer.start();

        try {
            producer.join();
            sumConsumer.join();
            avgConsumer.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
