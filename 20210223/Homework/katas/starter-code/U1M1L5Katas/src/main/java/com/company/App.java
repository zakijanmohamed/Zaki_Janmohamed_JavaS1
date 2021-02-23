package com.company;

public class App {
    public static int total(int[] array) {


        int sumValue = 0;
        for (int i = 0; i < array.length; i++) {
            sumValue = sumValue + array[i];
        }
        return sumValue;
    }

    public static int totalOdd(int[] array) {
        int oddValue = 0;
        for (int i = 1; i < array.length; i += 2) {
            oddValue += array[i];
        }
        return oddValue;
    }

    public static int totalEven(int[] array) {
        int evenValue = 0;
        for (int i = 0; i < array.length; i += 2) {
            evenValue += array[i];
        }
        return evenValue;
    }

    //    public static int secondLargest(int[] array) {
//        int high1 = Integer.MIN_VALUE;
//        int high2 = Integer.MIN_VALUE;
//        for (int num : array) {
//            if (array.length > high1) {
//                high2 = high1;
//                high1 = array.length;
//            } else if (array.length > high2) {
//                high2 = array.length;
//            }
//        }
//        return high2;
//
//    }

    public static String[] swapFirstAndLast (String[]array){
        String x = array[0];
        array[0] = array[array.length-1];
        array[array.length-1] =x;
        return array;

        }

    public static int[] reverse(int[] array) {
        int x = 0;
        for (int i = 0; i < array.length / 2; i++) {
            x = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = x;
        }
        return array;
    }

    public static String concatenateString(String [] array){
        String myReturnString ="";
        for (int i = 0;i<array.length;i++){
            myReturnString+=array[i];
        }
        return myReturnString;
    }

    public static int[] everyThird(int [] array){
        int [] array1= new int[array.length];
        int count =  0;
        for (int i = 3; i < array.length; i+=3){
            array1[count] = array[i];
            count++;
        }
        return array1;
        }

    }



