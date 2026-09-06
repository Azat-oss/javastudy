package ru.trop.lesson_2;

public class Car {

    private String name;
    private int year;
    private String manyfactoryName;
    private int power;

    public Car(String name, int year, String manyfactoryName, int power){
        this.name=name;
        this.year=year;
        this.manyfactoryName=manyfactoryName;
        this.power=power;
    }

    public Car(String name, int year){
        this.name=name;
        this.year=year;
        manyfactoryName="Не указано";
        power=0;


    }

    public String getName(){
        return name;
    }

    public int getYear(){
        return year;
    }

    public String getManyfactoryName(){
        return manyfactoryName;
    }

    public int getPower(){
        return power;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setYear(int year){
        this.year=year;
    }

    public void setManyfactoryName(String manyfactoryName){
        this.manyfactoryName=manyfactoryName;
    }

    public void setPower(int power){
        this.power=power;
    }

    public void PrintInfo(){
        System.out.println("Автомобиль: "+ name);
        System.out.println("Год выпуска: "+year);
        System.out.println("Производитель: "+manyfactoryName);
        System.out.println("Мощность двигателя: "+power+ " л.с.");
        System.out.println("******************");


    }


}
