import java.util.*;

public class MajorityElement {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < n; i++){
			values.add(input.nextInt());
		}input.close();
		sorting(n,values);
	}
	
	static void sorting(int n, ArrayList<Integer>values){
		Collections.sort(values);
		int target = values.get(n/2);
		System.out.println(version(values,target));
   	}
	
	static int version(ArrayList<Integer>values, int target){
		return version(values, target, 0);
	}
	
	private static int version(ArrayList<Integer>values,int target, int count){
		if (values.size()!=2){
			count = Collections.frequency(values,target);
			if (count > (values.size())/2){
			return 1;
		}else{
			return 0;
		}
	}
	 else{
	   return 0;
	   }
	}
 }
