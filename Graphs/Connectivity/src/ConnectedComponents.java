import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {

    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        boolean[] tracker = new boolean[adj.length];
        for(int i = 0; i < tracker.length; i++){
            if(!tracker[i]) {
                helper(adj, tracker, i);
                result++;
            }
        }
        return result;
    }

    private static void helper(ArrayList<Integer>[] adj, boolean[] tracker, int current){
        tracker[current] = true;
        for(int i : adj[current]){
            if(!tracker[i])
            helper(adj,tracker,i);
        }
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
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

