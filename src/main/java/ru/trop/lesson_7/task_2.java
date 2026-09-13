package ru.trop.lesson_7;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");

        String filePath = scanner.nextLine().trim();

        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isr)) {

            String longestLine = "";
            int maxLength = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                int currentLength = line.length();
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    longestLine = line;
                }
            }

            if (maxLength == 0) {
                System.out.println("Файл пуст");
            } else {
                System.out.println("Самая длинная строка: " + longestLine);
                System.out.println("Длина строки: " + maxLength);
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }


    }
}
