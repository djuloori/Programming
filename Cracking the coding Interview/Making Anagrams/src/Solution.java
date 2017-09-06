import java.util.*;

/**
 * Created by Dhruva Juloori on 9/5/2017.
 */
public class Solution {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String a = input.next();
        String b = input.next();
        int result = making_anagrams(a,b);
        System.out.print(result);
    }

    static int making_anagrams(String a, String b) {
        StringBuilder sb = new StringBuilder(b);
        ArrayList<Character> C1 = new ArrayList<>();
        ArrayList<Character> C2 = new ArrayList<>();
        for(int i = 0; i < a.length(); i++){
            char ch = a.charAt(i);
            if(sb.indexOf(String.valueOf(ch))!=-1){
                C1.add(ch);
                C2.add(ch);
                sb.deleteCharAt(sb.indexOf(String.valueOf(ch)));
            }else{
                continue;
            }
        }
        return (a.length() - C1.size()) + (b.length() - C2.size());
    }
}
