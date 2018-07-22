import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        String a = "Mr John Smith       ";
        String output = URLify(a);
        System.out.println(output);
    }

    public static String URLify(String input){
        input.replaceAll("\\s+","");
        String[] tokens = input.split("\\s");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tokens.length; i++){
         sb.append(tokens[i]);
         if(i!=tokens.length-1) {
             sb.append("%20");
         }
        }
        return sb.toString();
    }
}
