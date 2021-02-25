package com.company;

public class Microwave  {
    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    public Microwave (String manufacturer, String model, int secondsLeft, String time, boolean running) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.secondsLeft = secondsLeft;
        this.time = time;
        this.running = running;
    }

    public void togglePower() {
        System.out.println("Toggling power");
    }
    public void stop(){
        System.out.println("stopped");
    }
    public void clear(){
        System.out.println("cleared");
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

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void setSecondLeft(int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String station) {
        this.time = station;
    }


    public boolean isRunning() {
        return running;
    }

}
