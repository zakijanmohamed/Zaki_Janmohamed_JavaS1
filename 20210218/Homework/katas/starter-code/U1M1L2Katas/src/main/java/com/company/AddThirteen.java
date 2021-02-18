package com.company;
import java.util.Scanner;
public class AddThirteen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a number");
        int one =Integer.parseInt(scanner.next());

        int total = one + 13;
        System.out.println("The total is: " + total);

    }
}
