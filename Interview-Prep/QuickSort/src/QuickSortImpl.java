import java.util.Scanner;

public class QuickSortImpl {

    public static void quickSortHelper(int[] nums, int low, int high){
        if(low >= high){
            return;
        }
        int pivot = Partition(low,high,nums);
        quickSortHelper(nums,low,pivot-1);
        quickSortHelper(nums,pivot+1,high);
    }

    public static int Partition(int low, int high, int[] nums) {
        int pivot = nums[low];
        int i = low;
        int j = high;
        while(i < j){
            while (i <= high && nums[i] <= pivot){
                i++;
            }

            while(j >= low && nums[j] > pivot){
                j--;
            }

            if(i < j){
                swap(i,j,nums);
            }
        }
        swap(low,j,nums);
        return j;
    }

    public static void swap(int low, int high, int[] nums){
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] arrayToBeSorted = new int[length];
        for(int i = 0; i < arrayToBeSorted.length; i++){
            arrayToBeSorted[i] = input.nextInt();
        }
        quickSortHelper(arrayToBeSorted,0,arrayToBeSorted.length-1);
        for(int i = 0; i < arrayToBeSorted.length; i++){
            System.out.println(arrayToBeSorted[i]);
        }
    }
}
