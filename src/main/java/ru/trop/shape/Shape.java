package ru.trop.shape;

public abstract class Shape {
    private String color;
    private boolean isFilled;

    public Shape(String color, boolean isFilled){
        this.color=color;
        this.isFilled=isFilled;
    }

    public String getColor (){
        return color;
    }

    public boolean isFilled (){
        return isFilled;
    }

    public void setColor(String color){
        this.color=color;
    }

    public void setFilled(boolean isFilled){
        this.isFilled=isFilled;
    }

    public abstract double getArea();
    public abstract double getPerimetr();




}
