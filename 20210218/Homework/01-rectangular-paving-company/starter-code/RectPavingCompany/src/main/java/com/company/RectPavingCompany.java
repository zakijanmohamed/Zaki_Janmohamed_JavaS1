package com.company;
import java.util.Scanner;
public class RectPavingCompany {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        System.out.println (" Enter Width of Driveway:");
            int width =  Integer.parseInt(scanner.nextLine());

        System.out.println (" Enter Length of Driveway:");
            int length = Integer.parseInt(scanner.nextLine());

        int area= width*length;
        int perimeter =2*width + 2*length;
        System.out.println ("The total area of your driveway is " + area);
        System.out.println ("The total perimeter of your driveway is " + perimeter);

        Double costOfCement = area*12.50;
        Double costOfFraming = perimeter*8.25;
        System.out.println("The cost of cement for your driveway is $"+costOfCement);
        System.out.println("The cost of framing for your driveway is $"+costOfFraming);

        System.out.println (" Enter price of Cement:");
            int totalCostOfCement = Integer.parseInt(scanner.nextLine());
        System.out.println (" Enter price of Framing:");
            int totalCostOfFraming = Integer.parseInt(scanner.nextLine());

        int totalCost = totalCostOfCement+totalCostOfFraming;
        System.out.println("The total cost for your driveway is $" +totalCost);






    }
}
