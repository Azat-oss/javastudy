package ru.trop.lesson_5;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServicePerson {
    private final Map<Integer, Person> personMap = new LinkedHashMap<>();

    public void addPerson(String name, String city, Fine fine) {
        Person p = new Person(name, city, fine);
        personMap.put(p.getCode(), p);
        System.out.println("Добавлен гражданин: " + name + " (Код: " + p.getCode() + ")");
    }

    public void printAllData() {
        System.out.println("--- Список всех людей ---");
        if (personMap.isEmpty()) {
            System.out.println("(пусто)");
        }
        for (Person p : personMap.values()) {
            System.out.println(p);
        }
    }

    public void findPersonByCode(int code) {
        Person p = personMap.get(code);
        System.out.println(p != null ? "Найден: " + p : "Человек с кодом " + code + " не найден.");
    }

    public void findPersonsByFineType(Fine type) {
        System.out.println("--- Люди с типом штрафа: " + type + " ---");
        boolean found = false;
        for (Person p : personMap.values()) {
            if (p.getFineType() == type) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("Не найдено.");
    }

    public void findPersonsByCity(String city) {
        System.out.println("--- Люди в городе: " + city + " ---");
        boolean found = false;
        for (Person p : personMap.values()) {
            if (p.getCity().equalsIgnoreCase(city)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("Не найдено.");
    }

    public void addFineToPerson(int code, String description) {
        Person p = personMap.get(code);
        if (p != null) {
            p.addFine(description);
            System.out.println("Штраф добавлен коду " + code);
        } else {
            System.out.println("Человек не найден.");
        }
    }

    public void removeFineFromPerson(int code, String description) {
        Person p = personMap.get(code);
        if (p != null) {
            if (p.removeFine(description)) {
                System.out.println("Штраф удален у кода " + code);
            } else {
                System.out.println("Штраф не найден у кода " + code);
            }
        } else {
            System.out.println("Человек не найден.");
        }
    }

    public void updatePersonInfo(int code, String newName, String newCity, Fine newFineType) {
        Person p = personMap.get(code);
        if (p != null) {
            p.setName(newName);
            p.setCity(newCity);
            p.setFineType(newFineType);

            p.getFineDetails().clear();
            System.out.println("Данные обновлены для кода " + code);
        } else {
            System.out.println("Человек не найден.");
        }
    }










}
