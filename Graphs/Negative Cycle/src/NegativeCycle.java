import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NegativeCycle {

    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
       long[] tracker = new long[adj.length];
       Arrays.fill(tracker,Integer.MAX_VALUE);
       tracker[0] = 0;
       for(int i = 0; i < adj.length; i++){
           for(int j = 0; j < adj.length; j++){
               for(int k : adj[j]){
                   int dist_index = adj[j].indexOf(k);
                   if(tracker[j] + cost[j].get(dist_index) < tracker[k]){
                       tracker[k] = tracker[j] + cost[j].get(dist_index);
                       if(i == adj.length - 1){
                           return 1;
                       }
                   }
               }
           }
       }
        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        System.out.println(negativeCycle(adj, cost));
    }
}

