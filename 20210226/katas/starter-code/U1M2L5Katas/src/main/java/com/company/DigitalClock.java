package com.company;

import com.company.interfaces.Alarm;
import com.company.interfaces.Clock;

public class DigitalClock implements Clock, Alarm {
    private int hour;
    private int minute;

    public void setHour(int hour) {
        this.hour = hour;
    }


    public int getHour() {
        return hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }


    public int setMinute() {
        return minute;
    }

    public void displayTime(){
        System.out.println("time");
    }

    public int timer(int hour, int minute){
        return hour + minute;
    }
    public void sound(){
        System.out.println("sound, no sound");
    }
}
