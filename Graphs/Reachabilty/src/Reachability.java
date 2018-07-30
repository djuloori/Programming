import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
    static int count = 0;

    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        boolean[] track = new boolean[adj.length];
        Helper(adj,x,y,track);
        if(count > 0){
            return 1;
        }else{
            return 0;
        }
    }

    private static void Helper(ArrayList<Integer>[] adj, int x, int y, boolean[] track){
        if(x == y) {
            count++;
            return;
        }
        track[x] = true;
        for(int i = 0; i < adj.length; i++){
            if(i == x){
                for(int j : adj[i]){
                    if(!track[j]){
                        Helper(adj,j,y,track);
                    }
                }
            }
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

