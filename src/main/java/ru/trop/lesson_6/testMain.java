package ru.trop.lesson_6;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;
import java.time.format.TextStyle;
import java.util.Locale;


public class testMain {
    public static void main(String[] args) {

        // Проверка на високосность
        int chekYear = 2026;
        System.out.println("1. Проверка года " + chekYear + ":");

        IYearChek chek=(year -> ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)));

        System.out.println(chekYear + " год  " + (chek.isLeap(chekYear) ? "високосный" : "не високосный"));
        System.out.println();

        // Подсчет дней между датами

        LocalDate Data1 =LocalDate.of(2025,9,8);
        LocalDate Data2 =LocalDate.of(2026,9,8);
        System.out.println("2. Определение количества дней с " + Data1 + " по "+ Data2 );

        IDaysCounter daysCounter = (d1, d2) -> ChronoUnit.DAYS.between(d1, d2);

        System.out.println("   Количество дней: " + daysCounter.countDays(Data1, Data2));
        System.out.println();

        // Подсчет недель между датами
        System.out.println("3. Определение количества недель с " + Data1 + " по "+ Data2 );
        IDaysCounter weekCounter = (d1, d2) -> ChronoUnit.DAYS.between(d1, d2)/7;
        System.out.println("   Количество недель: " + weekCounter.countDays(Data1, Data2));
        System.out.println();

        // Определение название дня недели по дате
        System.out.println("4. Определение дня недели " + Data2 );

        Function<LocalDate, String> getDayNameRu = date ->
                date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("ru"));


        String dayName = getDayNameRu.apply(Data2);
        System.out.println("День недели: " + dayName);

    }
}
