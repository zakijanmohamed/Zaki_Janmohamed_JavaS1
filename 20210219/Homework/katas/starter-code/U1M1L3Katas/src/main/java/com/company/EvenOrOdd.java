package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;

        System.out.println("Please enter a number");
        input = Integer.parseInt(scanner.nextLine());

        if ((input & 1) == 0){
        System.out.println("Even");}
        else{
            System.out.println("Odd");}




    }
}
