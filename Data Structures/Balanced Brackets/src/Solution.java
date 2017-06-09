import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Dhruva Juloori on 6/8/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String S = input.next();
        balanced_brackets(S);
    }

    static void balanced_brackets(String S){
        Stack<Character> mystack = new Stack<>();
        Stack<Integer>  indexstack = new Stack<>();

        if(S.charAt(0) == '}' || S.charAt(0) == ']' || S.charAt(0) == ')'){ //40 41 91 93 123 125
            evaluation(0);
            return;
        }

        for(int i = 0; i < S.length(); i++) {
           if((int)S.charAt(i) == 40 || (int)S.charAt(i) == 41 || (int)S.charAt(i) == 91 || (int)S.charAt(i) == 93 || (int)S.charAt(i) == 123 || (int)S.charAt(i) == 125){
                if (S.charAt(i) == '{' || S.charAt(i) == '[' || S.charAt(i) == '(') {
                    mystack.push(S.charAt(i));
                    indexstack.push(i);
                }
                else {
                    if (S.charAt(i) == '}' && !mystack.empty()) {
                        if (mystack.peek() == '{') {
                            mystack.pop();
                            indexstack.pop();
                        } else {
                            evaluation(i);
                            return;
                        }
                    } else if (S.charAt(i) == ')' && !mystack.empty()) {
                        if (mystack.peek() == '(') {
                            mystack.pop();
                            indexstack.pop();
                        } else {
                            evaluation(i);
                            return;
                        }
                    } else if (S.charAt(i) == ']' && !mystack.empty()) {
                        if (mystack.peek() == '[') {
                            mystack.pop();
                            indexstack.pop();
                        } else {
                            evaluation(i);
                            return;
                        }
                    } else {
                        evaluation(i);
                        return;
                    }
                }
            }else{
                continue;
           }
        }

        if(S.charAt(0) != '}' && S.charAt(0) != ']' && S.charAt(0) != ')' && mystack.empty()){
            System.out.println("Success");
        }
        else if(S.charAt(0) != '}' && S.charAt(0) != ']' && S.charAt(0) != ')' && !mystack.empty()){
            int[] j = new int[indexstack.size()];
            int i = 0;
            while (!indexstack.empty()){
                j[i] = indexstack.pop();
                i++;
            }
            int a = j[j.length - 1];
            evaluation(a);
        }
    }

    static void evaluation(int x){
        System.out.println(x+1);
    }
}
