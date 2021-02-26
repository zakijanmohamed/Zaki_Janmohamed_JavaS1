package com.company;
import java.util.Scanner;
import com.company.interfaces.UserIO;

public class Input implements UserIO {

    Scanner scanner = new Scanner(System.in);

    public int readInt(String prompt){
        System.out.println(prompt);
        int input = Integer.parseInt(scanner.nextLine());
        return input;
    }

    public long readLong(String prompt){
        System.out.println(prompt);
        long input = Long.parseLong(scanner.nextLine());
        return input;
    }

    public double readDouble(String prompt){
        System.out.println(prompt);
        double input = Double.parseDouble(scanner.nextLine());
        return input;
    }

    public float readFloat(String prompt){
        System.out.println(prompt);
        float input = Float.parseFloat(scanner.nextLine());
        return input;
    }

    public String readString(String prompt){
        System.out.println(prompt);
        String input = (scanner.nextLine());
        return input;
    }















}
