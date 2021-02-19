package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            System.out.println("Please input a number between 15 and 32 (inclusive)");
            input = Integer.parseInt(scanner.nextLine());

            if (input >= 15 && input <= 32) {
                System.out.println("Your number is " + input);
            }
        } while (input < 15 || input > 32);
    }
}

