import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input;

        System.out.println("Enter a number  1 and 10 ");
        input = Integer.parseInt(scanner.nextLine());
        while (input < 1 || input > 10) {
            System.out.println("You must enter a number between 1 and 10. Please try again");
            System.out.println("Enter a number  1 and 10 ");
            input = Integer.parseInt(scanner.nextLine());


        }
        System.out.println("you entered a valid number: " + input);
    }

}

