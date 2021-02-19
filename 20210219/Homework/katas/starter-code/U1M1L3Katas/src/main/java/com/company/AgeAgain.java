package com.company;
import java.util.Scanner;
public class AgeAgain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How old are you? ");
        int input = Integer.parseInt(scanner.nextLine());

        if (input < 14) {
            System.out.println("Wow! " + input + "grade - that sounds exciting!");
        } else if (input >= 14 && input <= 18) {
            System.out.println("Are you planning on going to college?");
            String answer = scanner.nextLine();
            if (answer == "yes") {
                System.out.println("What college?");
            }
        }
    }
}
