import java.util.Scanner;
public class ArrayFunUserArray {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int array [] = new int[5];
        for (int i=0; i<5; i++){
            System.out.println("enter an integer");
            int input = Integer.parseInt(scanner.nextLine());
            array[i]=input;

        }
        for (int i=0; i<5; i++){
            System.out.println(array[i]);
        }
    }
}
