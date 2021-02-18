package com.company;
import java.util.Scanner;
public class MultiplyThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a number");
        int one =Integer.parseInt(scanner.next());

        System.out.println("Input another number");
        int two =Integer.parseInt(scanner.next());

        System.out.println("Input a third number");
        int three =Integer.parseInt(scanner.next());

        int total = (one*two*three);
        System.out.println("The product is: " + total);

    }
}