package com.company;
import java.util.Scanner;
public class CountByTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;

        System.out.println("Please enter a number");
        input = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < input; i+=2)
            System.out.println(i);}

    }

