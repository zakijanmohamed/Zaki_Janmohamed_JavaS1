public class ArrayFunReverseIt {
    public static void main(String[] args){
        int [] array1 ={1,2,3,4,5};
        int array2 [] = new int[5];
        int j=0;
        for(int i=4;i>=0;i--){
            array2[j]=array1[i];
            j++;
        }
        System.out.println("array 1 is: ");
        for(int i=0;i<5;i++) {
            System.out.println(array1[i]);
        }
        System.out.println("array 2 is: ");
        for(int i=0;i<5;i++){
            System.out.println(array2[i]);
        }
    }
}
