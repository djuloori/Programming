import java.util.Scanner;

public class String_Comparison {
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	String S1 = input.next();
	String S2 = input.next();
	input.close();
	System.out.println(edit_distance(S1,S2));
	}
	
	static int edit_distance(String A, String B){
		int[][] result = new int[A.length() + 1][B.length() + 1]; 
		for(int i = 0; i <= A.length(); ++i) {
			result[i][0] = i;
		}
		for(int i = 0; i <= B.length(); ++i) {
			result[0][i] = i;
		}
		for(int i = 1; i < A.length() + 1; i++){
			for (int j = 1; j < B.length() + 1; j++){
					int insertion = result[i][j-1] + 1;
					int deletion = result[i-1][j] + 1;
					int match = result[i-1][j-1];
					int mismatch = result[i-1][j-1] + 1;
					if (A.charAt(i-1) == B.charAt(j-1)){
						result[i][j] = Math.min(Math.min(insertion, deletion), match);
					}else{
						result[i][j] = Math.min(Math.min(insertion, deletion),mismatch);
					}
				}
			}
		
		return result[A.length()][B.length()];
	 }
	}

