package com.company;

public class Car  {
    private String make;
    private String model;
    private String type;
    private String color;
    private String engine;
    private String transmission;
    private int numDoors;
    private double mpg;
    private int milesDriven;

    public Car (String make, String model, String type, String color, String engine, String transmission,int numDoors, double mpg, int milesDriven) {
        this.make = make;
        this.model = model;
        this.type = type;
        this.color  = color;
        this.engine = engine;
        this.transmission = transmission;
        this.numDoors = numDoors;
        this.mpg = mpg;
        this.milesDriven =milesDriven;
    }

    public void drive() {
        System.out.println("miles");
    }
    public void honk()
    {
        System.out.println("honking");}

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getType(){
        return type;
    }
    public void setType(int numSpeakers){
        this.type =type;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
    public String getEngine() {
        return engine;
    }
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    public String getTransmission() {
        return transmission;
    }

    public int getNumDoors(){
        return numDoors;
    }
    public void setNumDoors(int volume){
        this.numDoors =numDoors;
    }
    public double getMpg(){
        return mpg;
    }
    public int getMilesDriven(){
        return milesDriven;
    }
    public void setMilesDriven(int milesDriven){
        this.milesDriven =milesDriven;
    }


}

