package ru.trop.utest;

public class CalcMain {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        int res = calc.addNum(5,2);

        System.out.println("Summa 5 + 2 = "+res);

    }
}
