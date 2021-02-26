package com.company;

import com.company.interfaces.Shape;


public class Triangle implements Shape {

    private double side;

    public void setSide(double side) {
        this.side = side;
    }


    public double getSide() {
        return side;
    }


    public double perimeter() {
        return  side;
    }

    public double area() {

        return side;
    }

}


