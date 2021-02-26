import java.util.Scanner;

public class SomeMath {
    public static int total5(int a, int b, int c, int d, int e) {
        int sum = a + b + c + d + e;
        return sum;
    }

    public static double average5(int a, int b, int c, int d, int e) {
        double average = (a + b + c + d + e) / 5;
        return average;
    }

    public static double largest5(double a, double b, double c, double d, double e) {
        double largest;

        if (a > b && a > c && a > d && a > e) {
            largest = a;
        } else if (b > a && b > c && b > d && b > e) {
            largest = b;
        } else if (c > a && c > b && c > d && c > e) {
            largest = c;
        } else if (d > a && d > b && d > c && d > e) {
            largest = d;
        } else {
            largest = e;
        }
        return largest;
    }


    public static void main(String[] args) {


        System.out.println(total5(1, 2, 3, 4, 5));
        System.out.println(average5(1, 3, 5, 7, 9));
        System.out.println(largest5(42.0, 35.1, 2.3, 40.2, 15.6));


    }
}
