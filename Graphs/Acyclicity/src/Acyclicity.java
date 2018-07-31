import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {


    private static int acyclic(ArrayList<Integer>[] adj) {
        boolean[] tracker = new boolean[adj.length];
        boolean[] recursiveStack = new boolean[adj.length];
        for(int i = 0; i < adj.length; i++){
            if(!tracker[i]) {
               if (helper(adj, tracker, i, recursiveStack) == 1){
                 return 1;
               }
            }

        }
        return 0;
    }

    private static int helper(ArrayList<Integer>[] adj,boolean[] tracker,int x, boolean[] recursiveStack){
        tracker[x] = true;
        recursiveStack[x] = true;
        for(int j : adj[x]){
            if(!tracker[j]){
                int result = helper(adj,tracker,j,recursiveStack);
                if(result == 1){
                    return 1;
                }
            }else if(recursiveStack[j]){
                return 1;
            }
        }
        recursiveStack[x] = false;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

