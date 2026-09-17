package ru.trop.utest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import ru.trop.lesson_10.Circle;

public class CircleTest {
    @Test
    public void testGetArea(){

        Circle circle = new Circle(10.0);
        double result = circle.getArea();
        assertEquals(Math.PI*10*10, result, 1e-2, "Площадь окружности радиусом 10 должна равняться 314.16");
    }

   @Test
   public void testGetAreaRadiusZero(){
       assertThrows(IllegalArgumentException.class,()->new Circle(0));
   }


   @Test
    public void testGetAreaRadiusNegative(){
        assertThrows(IllegalArgumentException.class,()->new Circle(-10));
   }

}
