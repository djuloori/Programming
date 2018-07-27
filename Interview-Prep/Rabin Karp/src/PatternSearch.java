import java.util.Scanner;

public class PatternSearch {

    private static final int PRIME = 3;

   public static int validatePattern(String text, String pattern){
       if(pattern.length() > text.length()) return -1;
       char[] t = text.toCharArray();
       char[] p = pattern.toCharArray();
       int textLength = text.length();
       int patternLength = pattern.length();
       int hashLength = p.length - 1;
       int patternHash = createHash(p,hashLength);
       int textHash = createHash(t,hashLength);
       for(int i = 1; i <= textLength - patternLength + 1; i++){
           if(textHash == patternHash && checkEqual(p,t,i-1,hashLength)){
               return i - 1;
           }

           if(i + hashLength < textLength) {
               textHash = rollingHash(t, i, i + hashLength, textHash);
           }
       }
       return -1;
   }

   public static int rollingHash(char[] text, int start, int end, int oldHash){
       int newHash = oldHash - text[start-1];
       newHash = newHash/PRIME;
       newHash+=text[end]*Math.pow(PRIME,end-start);
       return newHash;
   }

   public static boolean checkEqual(char[] pattern, char[] text, int start, int end){
       int j = 0;
       for(int i = start; i <= end; i++){
           if(text[i] != pattern[j]){
               return false;
           }
           j++;
       }
       return true;
   }


   public static int createHash(char[] text, int len){
       int hash = 0;
       for(int i = 0; i <= len; i++){
           hash+= text[i] * Math.pow(PRIME,i);
       }
       return hash;
   }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String text = input.next();
        String pattern = input.next();
        System.out.println(validatePattern(text,pattern));
    }
}
