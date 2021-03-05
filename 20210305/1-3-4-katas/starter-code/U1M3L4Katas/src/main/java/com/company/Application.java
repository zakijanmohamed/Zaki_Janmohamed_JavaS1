package com.company;

import java.io.FileNotFoundException;

public class Application {

    public static void main(String[] args) {

        System.out.println("Current saved animals file:");
        try{
            Pets.readPetsFromFile();
        }catch(FileNotFoundException e){
            System.out.println("The following file does not seem to exist:");
        }catch(Exception e){
            System.out.println("The following file does not exist: " + e.getMessage());
        }

        try {
            int petIndex = Pets.choosePet();
            String chosenPet = Pets.retrievePet(petIndex);
            Pets.writePetToFile(chosenPet);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Please choose an available pet");
        }catch(FileNotFoundException e){
            System.out.println("The following file does not seem to exist:");
        }catch(Exception e){
            System.out.println("Please enter a valid number.");
        }

        System.out.println("New saved animals file:");

        try{
            Pets.readPetsFromFile();
        }catch(IndexOutOfBoundsException e){
            System.out.println("The following file does not seem to exist:");
        }catch(Exception e ){
            System.out.println("The following file does not exist: " + e.getMessage());
        }

        System.out.println("Have a nice day!");

    }
}
