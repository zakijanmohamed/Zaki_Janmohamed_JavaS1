import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String array [] = new String[5];
        for (int i=0; i<5; i++){
            System.out.println("enter a word");
            String input =(scanner.nextLine());
            array[i]=input;

        }
        for (int i=0; i<5; i++){
            System.out.println(array[i]);
        }
    }
}
