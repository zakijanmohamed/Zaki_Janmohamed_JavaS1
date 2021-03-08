public class Calculator {
    public int add(int x, int y){

        return x+y;
    }
    public double add(double x, double y){

        return x+y;
    }
    public int subtract(int x, int y){

        return x-y;
    }
    public double subtract(double x, double y){

        return x-y;
    }
    public int multiply(int x, int y){
        return x*y;
    }
    public double multiply(double x, double y){

        return x*y;
    }
    public int divide(int x, int y){
        return x/y;
    }
    public double divide(double x, double y){

        return x/y;
    }
    public static void main(String [] args){
        Calculator calculator = new Calculator();
        System.out.println("1+1 = "+calculator.add(1,1));
        System.out.println("23-52 ="+calculator.subtract(23,52));
        System.out.println("34*2 ="+calculator.multiply(34,2));
        System.out.println("12/3 ="+calculator.divide(12,3));
        System.out.println("12/7 ="+calculator.divide(12,7));
        System.out.println("3.4+2.3 ="+ calculator.add(3.4,2.3));
        System.out.println("6.7*4.4 ="+ calculator.multiply(6.7,4.4));
        System.out.println("5.5-0.5 ="+calculator.subtract(5.5,0.5));
        System.out.println("10.8/2.2 ="+calculator.divide(10.8,2.2));
    }
}

