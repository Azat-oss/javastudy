package ru.trop.utest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {
    @Test
    public void testAddNum() {
        Calculator calc = new Calculator();
        int result = calc.addNum(5, 2);


        assertEquals(7, result,"Сумма 5 и 2 равна 7");
    }



}
