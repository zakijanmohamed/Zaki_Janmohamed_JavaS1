package com.company;

import com.company.interfaces.Shape;

public class Square implements Shape {

    private double side;

    public void setSide(double side) {
        this.side = side;
    }


    public double getSide() {
        return side;
    }


    public double perimeter() {
        return 4 * side;
    }

    public double area() {
        return side * side;
    }

}

