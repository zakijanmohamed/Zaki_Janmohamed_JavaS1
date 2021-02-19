package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;

        do {
            System.out.println("Please guess a number between 1 and 100 (inclusive)");
            input = Integer.parseInt(scanner.nextLine());

            if (input >= 1 && input <= 100) {
                if (input == 42) {
                    System.out.println("That's the number I was looking for! 42 is definitely the answer!");
                } else {
                    System.out.println("Try again!");
                }

            } else {
                System.out.println("Invalid input");
            }
        } while (input != 42);
    }

}

