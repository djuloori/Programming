import java.util.*;

/**
 * Created by Dhruva Juloori on 6/30/2017.
 */
public class minheap {
    static HashMap<Integer,Integer> key = new HashMap<>();
    static HashMap<Integer, Integer> value = new HashMap<>();
    static int i = 0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Integer[] input_array = new Integer[n];
        for(int i = 0; i < input_array.length; i++){
            input_array[i] = input.nextInt();
        }
        build_heap(input_array);
    }

    static void build_heap(Integer[] a){
       for(int i = a.length/2; i >= 0; i--){
            shift_operation(i,a);
        }
        System.out.println(key.size());
        if(key.size() > 0) {
            for (int i = 0; i < key.size(); i++) {
                System.out.println(key.get(i) + " " + value.get(i));
            }
        }else{
            return;
        }
   }

   static void shift_operation(int i,Integer[] a){
      int left = left_child(i);
      int right = right_child(i);
      int min = 0;
      int c = 0;
      if(left >= a.length  && right >= a.length){
          return;
      }else{
          if(left < a.length && right < a.length) {
              if(a[left] < a[right]){
                  min = a[left];
                  c = left;
              }else if(a[right] < a[left]){
                  min = a[right];
                  c = right;
              }
          }else if(left < a.length && right >= a.length){
              min = a[left];
              c = left;
          }else{
              return;
          }
          if(a[i] > min){
           swap(i,c,a);
          }else{
              return;
          }
          shift_operation(c,a);
      }
   }

   static void swap(int a, int b, Integer[] c){
       if(i < 4*c.length) {
           key.put(i,a);
           value.put(i,b);
                i++;
       }
       int temp = 0;
          temp = c[a];
          c[a] = c[b];
          c[b] = temp;
   }

   static int left_child(int i){
       return 2*i + 1;
   }

   static int right_child(int i){
       return 2*i + 2;
   }
}
