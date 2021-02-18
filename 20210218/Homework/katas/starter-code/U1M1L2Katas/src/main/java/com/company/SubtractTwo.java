package com.company;
import java.util.Scanner;
public class SubtractTwo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a number");
        int one =Integer.parseInt(scanner.next());

        System.out.println("Input another number");
        int two =Integer.parseInt(scanner.next());

        int total = (one - two);
        System.out.println("The difference is: " + total);

    }
}
