package com.company;

public class CoffeeMaker  {
    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public CoffeeMaker(String manufacturer, String model, int carafeSize, int cupsLeft, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.carafeSize = carafeSize;
        this.cupsLeft = cupsLeft;
        this.powered = powered;
    }

    public void brew() {
        System.out.println("brewing");
    }

    public void pourCoffee(){
        System.out.println("number of cups left");

    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public int getCarafeSize(){
        return carafeSize;
    }
    public void setCarafeSize(int carafeSize){
        this.carafeSize =carafeSize;
    }
       public int getCupsLeft(){
        return cupsLeft;
    }
    public void setCupsLeft(int cupsLeft){
        this.cupsLeft =cupsLeft;
    }
    public boolean isPowered(){
        return powered;
    }

}
