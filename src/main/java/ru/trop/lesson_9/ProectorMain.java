package ru.trop.lesson_9;

import java.awt.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ProectorMain {
    public static void main(String[] args) {

        List<Proector> proectorList = List.of(
                new Proector("Салют", LocalDate.of(2026,12,12),15000.45,"Сони"),
                new Proector("Рубин",LocalDate.of(2026,8,30),37006.00,"Самсунг"),
                new Proector("Sunrise",LocalDate.of(2020,7,3),27000.00,"Sony"),
                new Proector("Vivi",LocalDate.of(2025,4,23),47000.00,"Sony"),
                new Proector("WinGold",LocalDate.of(2024,7,3),22000.00,"LG"),
                new Proector("WinGold",LocalDate.of(1999,7,3),2000.00,"Philips")

        );

        System.out.println("Список проекторов: "+proectorList);

        List<Proector> sonyList =proectorList.stream()
                .filter(factory->factory.getNameFactory().equals("Сони")||factory.getNameFactory().equals("Sony"))
                .toList();
        System.out.println();
        System.out.println("Отфильтрован по производителю: "+ sonyList);
        System.out.println();

        System.out.println("Проектораы текущего 2026 года: ");
         List<Proector> year2026 = proectorList.stream()
                 .filter(year ->year.getYearProdaction().getYear()==LocalDate.now().getYear())
                 .toList();
        System.out.println("Проектораы текущего года: "+ year2026);
        System.out.println();

        System.out.println("Проектораы дороже 30 000,00 руб.: ");
        List<Proector> priceTop = proectorList.stream()
                .filter(price ->price.getPrice()>30000.00)
                .toList();
        System.out.println("Дороже 30 000 рублей: "+ priceTop);

        List<Proector> sortPricemax = proectorList.stream()
                .sorted(Comparator.comparingDouble(Proector::getPrice))
                .toList();
        System.out.println("По удорожанию: "+ sortPricemax);

        List<Proector> priceMin = proectorList.stream()
                .sorted(Comparator.comparingDouble(Proector::getPrice)).toList().reversed();
        System.out.println("По убыванию: "+ priceMin);

        List<Proector> yearMax = proectorList.stream()
                .sorted(Comparator.comparing(Proector::getYearProdaction))
                .toList();
        System.out.println("По возрастанию года выпуска: "+ yearMax);

        List<Proector> yearMin = proectorList.stream()
                .sorted(Comparator.comparing(Proector::getYearProdaction)).toList().reversed();
        System.out.println("Годы по убыванию: "+ yearMin);












    }
}
