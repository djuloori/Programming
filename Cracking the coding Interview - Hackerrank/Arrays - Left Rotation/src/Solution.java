import java.util.Scanner;

/**
 * Created by Dhruva Juloori on 9/2/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size_of_the_array = input.nextInt();
        int no_of_rotations = input.nextInt();
        int[] elements = new int[size_of_the_array];
        for (int i = 0; i < size_of_the_array; i++) {
            elements[i] = input.nextInt();
        }
        rotations(elements, no_of_rotations);
    }

    static void rotations(int[] array, int rotations) {
       int difference = array.length - rotations;
       if(difference == 0){
           for(int i = 0; i < array.length; i++){
               System.out.print(array[i] + " ");
           }
       }else if(difference > 0){
            int[] temp = new int[rotations];
            for(int i = 0; i < rotations; i++){
                temp[i] = array[i];
            }
            int[] output_array = new int[array.length];
            for(int i = 0; i < output_array.length; i++){
                if(rotations+i < array.length) {
                    output_array[i] = array[rotations + i];
                }else{
                    output_array[i] = temp[rotations - array.length + i];
                }
            }
            for(int i = 0; i < output_array.length; i++){
                System.out.print(output_array[i] + " ");
            }
       }else{
              boolean flag = true;
              int r1 = rotations;
              while(flag){
                   r1 = r1 - array.length;
                   if(r1 < array.length){
                       flag = false;
                   }else{
                       continue;
                   }
              }
              rotations(array,r1);
       }
    }
}
