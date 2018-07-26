import java.util.Scanner;

public class MergeSortImpl {

    public static void mergeSortHelper(int[] nums){
        if(nums.length < 2){
            return;
        }
        int mid = nums.length/2;
        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];
        for(int i = 0; i < mid; i++){
            left[i] = nums[i];
        }
        for(int j = mid; j < nums.length; j++){
            right[j - mid] = nums[j];
        }
        mergeSortHelper(left);
        mergeSortHelper(right);
        merge(left,right,nums);
    }

    public static void merge (int[] left, int[] right, int[] nums){
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length){
             if(left[i] <= right[j]){
                 nums[k] = left[i];
                 i++;
             }else{
                 nums[k] = right[j];
                 j++;
             }
             k++;
        }

        while(i < left.length){
            nums[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length){
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] arrayToBeSorted = new int[length];
        for(int i = 0; i < arrayToBeSorted.length; i++){
            arrayToBeSorted[i] = input.nextInt();
        }
        mergeSortHelper(arrayToBeSorted);
        for(int i = 0; i < arrayToBeSorted.length; i++){
            System.out.println(arrayToBeSorted[i]);
        }
    }
}
