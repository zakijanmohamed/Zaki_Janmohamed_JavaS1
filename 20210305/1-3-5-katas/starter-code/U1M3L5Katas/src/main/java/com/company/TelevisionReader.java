package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelevisionReader {

    public static void main(String[] args) {

        // CODE GOES
        FileIO fileIO = new FileIO();

        List<Television> list = new ArrayList<Television>();

        Map<String,Television> television = new HashMap<String,Television>();

        try {
            list = fileIO.getTelevisions("C:/Users/zkj19/OneDrive/Desktop/Working Folder JavaS1/1-3-5-katas/starter-code/U1M3L5Katas/televisions.csv");

        }
        catch (FileNotFoundException e){
            System.out.println("file not found.");
        }
        list.forEach((n)->{if(n.getScreenSize()>60){
            System.out.println(n.getBrand());}
        });
        for (Television i:list){
            television.put(i.getBrand(),i);
        }
        System.out.println("-----------");
        for (String i: television.keySet()){
            System.out.println(i);
        }
        int sum =0;
        int total = 0;
        double average;

        for (Television i:list){
            sum+=i.getScreenSize();
            total++;
        }
        average = sum/total;
        System.out.println("--------------");
        System.out.println("Average screen size " + average);

        int largest = 0;
        for (Television i:list){
            for(Television x: list){
                if (i.getScreenSize()>x.getScreenSize()) {
                    largest=i.getScreenSize();

                }
                else {
                    largest =x.getScreenSize();
                }
            }
        }
        System.out.println("--------------");
        System.out.println("Largest screen size is " +largest);

    }

}
