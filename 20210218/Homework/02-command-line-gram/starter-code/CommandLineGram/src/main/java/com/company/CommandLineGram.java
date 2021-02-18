package com.company;
import java.util.Scanner;
public class CommandLineGram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println (" Enter First Name:");
            String fN = scanner.nextLine();
        System.out.println (" Enter Last Name:");
            String lN = scanner.nextLine();
        System.out.println (" Enter Email:");
            String email = scanner.nextLine();
        System.out.println (" Enter Twitter handle:");
            String twitter = scanner.nextLine();
        System.out.println (" Enter Age:");
            int age = Integer.parseInt(scanner.nextLine());
        System.out.println (" Enter Country:");
            String country = scanner.nextLine();
        System.out.println (" Enter Profession:");
            String profession = scanner.nextLine();
        System.out.println (" Enter favorite Operating System:");
            String os = scanner.nextLine();
        System.out.println (" Enter favorite programming language:");
            String pl = scanner.nextLine();
        System.out.println (" Enter favorite computer Scientist:");
            String cs = scanner.nextLine();
        System.out.println (" Enter favorite keyboard shortcut:");
            String kbs = scanner.nextLine();
        System.out.println (" If you could be any superhero, who would it be?:");
            String superhero = scanner.nextLine();

        System.out.println("hello " + fN + lN + " age " + age + " from " + country);
        System.out.println("your email address is: " + email + " and Twitter handle is: " + twitter);
        System.out.println("you are a " + profession +" who uses " + os + " and knows " + pl + " and how to use " + kbs + " because you like " + cs);
        System.out.println("you are an awesome man because " + superhero + " is your favorite superhero ");
    }
}
