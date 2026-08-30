package ru.trop.lesson_2;

import java.time.LocalDate;

public class Book {

    private String nameBook;
    private String fullNameAuthor;
    private LocalDate dateBook;
    private String janBook;
    private int countPage;

    public Book (String nameBook, String fullNameAuthor, LocalDate dateBook, String janBook, int countPage)
    {
        this.nameBook = nameBook;
        this.fullNameAuthor = fullNameAuthor;
        this.dateBook = dateBook;
        this.janBook = janBook;
        this.countPage = countPage;
    }

    public Book (String nameBook, String fullNameAuthor)
    {
        this.nameBook = nameBook;
        this.fullNameAuthor = fullNameAuthor;
        this.dateBook = null;
        this.janBook = "not genre";
        this.countPage = 0;
    }


    public String getNameBook(){
        return nameBook;
    }

    public String getFullNameAuthor(){
        return fullNameAuthor;
    }

    public LocalDate getDateBook(){
        return dateBook;
    }

    public String getJanBook (){
        return janBook;
    }

    public int getCountPage(){
        return countPage;
    }

    public void setNameBook(String nameBook){
        this.nameBook=nameBook;
    }

    public void setFullNameAuthor(String fullNameAuthor){
        this.fullNameAuthor = fullNameAuthor;
    }

    public void setDateBook(LocalDate dateBook){
        this.dateBook = dateBook;
    }

    public void setJanBook (String janBook){
        this.janBook=janBook;
    }

    public void setCountPage (int countPage){
        this.countPage = countPage;
    }

    public void displayInfo(){
        System.out.println("Name book: " + nameBook);
        System.out.println("Name author: " + fullNameAuthor);
        System.out.println("Date book: "+dateBook);
        System.out.println("Janre: "+janBook);
        System.out.println("Count page: "+countPage);
        System.out.println("**************************");

    }

}
