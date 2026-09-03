package ru.trop.lesson_2;
import ru.trop.lesson_2.Book;

import java.time.LocalDate;

public class BookMain {
    public static void main (String[] args){

        Book book1 = new Book("C#", "Gerbert Shildt",
                LocalDate.of(2013,1,1), "Programming", 500);

        book1.displayInfo();

        Book book2 = new Book("Война и мир", "Lev Толстой",
                LocalDate.of(2020,1,1), "novel", 800);

        book2.displayInfo();

        book2.setCountPage(801);
        book2.setFullNameAuthor("Лев Толстой");
        book2.displayInfo();

        Book book3 = new Book("Eugene Onegin","Alexander Pushkin");
        book3.displayInfo();






    }
}
