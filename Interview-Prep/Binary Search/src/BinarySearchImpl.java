import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchImpl {

    public static int binarySearchHelper(int[] nums, int low, int high, int target){
        if(low > high){
            return -1;
        }
        int mid = (low + high)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] > target){
            return binarySearchHelper(nums,low,mid-1,target);
        }else{
            return binarySearchHelper(nums,mid+1,high,target);
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] array = new int[length];
        for(int i = 0; i < array.length; i++){
            array[i] = input.nextInt();
        }
        Arrays.sort(array);
        int target  = 1;
        System.out.println(binarySearchHelper(array,0,array.length-1,target));
    }

}
