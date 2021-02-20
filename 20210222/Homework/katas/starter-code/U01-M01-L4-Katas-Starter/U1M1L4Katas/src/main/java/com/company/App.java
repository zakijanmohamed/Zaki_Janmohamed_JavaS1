package com.company;

public class App {


    // subtract
    static int subtract(int a, int b) {
        return (a - b);
    }


    // subtractOrZero
    static int subtractOrZero(int a, int b) {
        int c = (a - b);

        if (c >= 0) {
            return (c);
        } else {
            return (0);
        }

    }

    // max
    static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return (a);
        } else if (b > a && b > c) {
            return (b);
        } else {
            return (c);
        }

    }


    // min
    static int min ( int a, int b, int c){
        if (a < b && a < c) {
            return (a);
        } else if (b < a && b < c) {
            return (b);
        } else {
            return (c);
        }
    }


    // isLarger
    static boolean isLarger ( int first, int second){
        if (first > second) {
            return true;
        }
        else {
            return false;
        }

    }
}
