package com.company;
import java.util.Scanner;
public class LuxuryTaxCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Salary for Player 1");
            int player1 =Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Salary for Player 2");
            int player2 =Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Salary for Player 3");
            int player3 =Integer.parseInt(scanner.nextLine());

        int totalSalary = player1+player2+player3;
        System.out.println("The total Salaries for all Players is: $ " + totalSalary);

        double luxuryTax = (totalSalary-40000000)*0.18;

        if (totalSalary > 40000000 ) {
            System.out.println("Luxury tax owed is $ " + luxuryTax);
        }

        else {
            System.out.println("No luxury tax owed.");
        }
    }
}
