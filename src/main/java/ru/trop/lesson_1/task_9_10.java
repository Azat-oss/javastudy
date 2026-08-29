package ru.trop.lesson_1;

import java.util.Random;

public class task_9_10 {
    public static void main (String[] args){

        //Задание №9

        int[] arr=new int[10];
        Random random = new Random();
        for (int i=0; i< arr.length;i++){
            arr[i]=random.nextInt(100)-50;
            System.out.print(arr[i]+" ");
        }

        System.out.println(" ");

        int max =arr[0];
        for (int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(" ");
        System.out.println("Maimum: "+max);

        int min =arr[0];
        for (int i=1; i<arr.length; i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println(" ");
        System.out.println("Mimimum: "+min);

        int pozitivCount=0;
        int negativCount=0;
        int zeroCount =0;

        for (int val:arr){
            if (val>0){
                pozitivCount++;
            }
            else if (val<0){
                negativCount++;
            }
            else {zeroCount++;}
        }

        System.out.println(" ");
        System.out.println("Pologitelnye "+pozitivCount);
        System.out.println("Otricatelnye "+negativCount);
        System.out.println("Nolevye "+zeroCount);


        //Задание №10
        // Создание положительного массива из предыдущего
        int[]arrPozitiv = new int[pozitivCount];

        int index =0;
        for (int val:arr){
            if (val>0){
                arrPozitiv[index]=val;
                index++;
            }
        }
        System.out.println("Massiv pologitelnye: ");

        for (int val:arrPozitiv){
            System.out.print(val+" ");
        }

        System.out.println();

        // Создание отрицательного массива из предыдущего

        int index2 =0;
        int[]arrNegativ=new int[negativCount];

        for (int val:arr){
            if (val<0){
                arrNegativ[index2]=val;
                index2++;
            }
        }
        System.out.println("Massiv otricatelnye: ");

        for (int val:arrNegativ){
            System.out.print(val+" ");
        }

        System.out.println();

    }
}
