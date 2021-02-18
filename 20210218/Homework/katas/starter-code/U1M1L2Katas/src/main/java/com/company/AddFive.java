package com.company;
import java.util.Scanner;
public class AddFive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a number");
            int one =Integer.parseInt(scanner.next());

        System.out.println("Input another number");
        int two =Integer.parseInt(scanner.next());

        System.out.println("Input a third number");
        int three =Integer.parseInt(scanner.next());

        System.out.println("Input fourth number");
        int four =Integer.parseInt(scanner.next());

        System.out.println("Input final number");
        int five =Integer.parseInt(scanner.next());

        int total = one+two+three+four+five;
        System.out.println("The sum of those numbers is: " + total);

    }
}
