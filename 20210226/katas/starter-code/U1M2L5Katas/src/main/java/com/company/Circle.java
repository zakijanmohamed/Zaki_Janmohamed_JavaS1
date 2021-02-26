package com.company;
import com.company.interfaces.Shape;


        public class Circle implements Shape {

            private double radius;

            public void setRadius(double radius) {
                this.radius = radius;
            }


            public double getRadius() {
                return radius;
            }


            public double perimeter() {
                return 2 * radius* Math.PI;
            }

            public double area() {
                return Math.pow(Math.PI * radius,2);
            }

    }

