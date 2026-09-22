package ru.trop.lesson_11.model;

import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private LocalDate age;
    private String email;

    public User(){}

    public User (int id,String name, LocalDate age, String email){
        this.id = id;
        this.name=name;
        this.age = age;
        this.email=email;
    }

    public User(int id, String name, LocalDate age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = null;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName (String name){
        this.name=name;
    }

    public LocalDate getAge (){
        return age;
    }
    public void setAge (LocalDate age){
        this.age=age;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail (String email){
        this.email=email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
