package com.company;
import java.util.Scanner;
public class YourAgeCan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input an Age ");
        int input = Integer.parseInt(scanner.nextLine());

        if(input >= 100){
            System.out.println("Is more than a century old!");
        }
        else if(input >= 80 && input <= 89){
            System.out.println("Is an Octogenarian!");
        }
        else if(input >= 65){
            System.out.println("Can retire!");
        }
        else if(input >= 55){
            System.out.println("Is eligible for AARP!");
        }
        else if(input >= 35){
            System.out.println("Can be President!");
        }
        else if(input >= 21){
            System.out.println("Can drink Alcohol!");
        }
        else if (input >= 18){
            System.out.println("Can Vote!");
        }
        else{
            System.out.println("You're not old enough");
        }
    }
}
