package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {
        System.out.println("Welcome to Hi-Low!");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(100) + 1;

        System.out.println("Please enter your name");
        String name = scanner.nextLine();
        System.out.println("OK, " + name + ", here are the rules:");
        int input;
        int count = 0;
        do {

            System.out.println("Guess a number between 1 and 100");
            input = Integer.parseInt(scanner.nextLine());

            if (input == number) {
                System.out.println("Congratulations, " + name + "! You win!");
                System.out.println("It took you" + count++ + "guesses to find my number!");
            } else if (input > number) {
                System.out.println("Too High!");
            } else if (input < number) {
                System.out.println("Too Low!");
            }

        }
        while (input != number);
    }
}
