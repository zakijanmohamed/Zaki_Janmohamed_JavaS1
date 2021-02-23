package com.company;

public class App {
    public static int total(int[] array) {

//kata 1

        int sumValue = 0;
        for (int i = 0; i < array.length; i++) {
            sumValue = sumValue + array[i];
        }
        return sumValue;
    }

//kata 2

    public static int totalOdd(int[] array) {
        int oddValue = 0;
        for (int i = 1; i < array.length; i += 2) {
            oddValue += array[i];
        }
        return oddValue;
    }

//kata 3

    public static int totalEven(int[] array) {
        int evenValue = 0;
        for (int i = 0; i < array.length; i += 2) {
            evenValue += array[i];
        }
        return evenValue;
    }
//kata 4

    public static int secondLargestNumber(int[] array) {
        int high1 = Integer.MIN_VALUE;
        int high2 = Integer.MIN_VALUE;
        for (int i=0;i<array.length;i++) {
            if (array[i]> high1) {
                high2 = high1;
                high1 = array[i];
            } else if (array[i] > high2) {
                high2 = array[i];
            }
        }
        return high2;

    }
//kata 5

    public static String[] swapFirstAndLast (String[]array){
        String x = array[0];
        array[0] = array[array.length-1];
        array[array.length-1] =x;
        return array;

    }

//kata 6

    public static int[] reverse (int[] array) {
        int x = 0;
        for (int i = 0; i < array.length / 2; i++) {
            x = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = x;
        }
        return array;
    }

//kata 7

    public static String concatenateString(String [] array){
        String myReturnString ="";
        for (int i = 0;i<array.length;i++){
            myReturnString+=array[i];
        }
        return myReturnString;
    }

//kata 8

    public static int[] everyThird(int [] array){
        int [] array1= new int[array.length];
        int count =  0;
        for (int i = 3; i < array.length; i+=3){
            array1[count] = array[i];
            count++;
        }
        return array1;
        }

//kata 9

    public static int[] lessThanFive(int[] array){
        int numberLessThanFive =0;

        for(int i: array)
            if (i<5)
                numberLessThanFive++;

        if (numberLessThanFive != 0) {
            int[] temp = new int[numberLessThanFive];
            int index = 0;

            for (int i : array) {
                if (i < 5) {
                    temp[index] = i;
                    index++;
                }
            }
            return temp;
        } else {
            return null;
        }

    }
}