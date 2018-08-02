import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        boolean used[] = new boolean[adj.length];
        ArrayList<Integer> result = new ArrayList();
        Stack order = new Stack();
        for(int i = 0; i <  adj.length; i++){
            if(!used[i]) dfs(adj,used,order,i);
        }
        while(!order.empty()){
            result.add((Integer) order.pop());
        }

        return result;
    }

    private static void dfs(ArrayList<Integer>[] adj, boolean[] used, Stack order, int s) {
        used[s] = true;
        for(int j : adj[s]){
            if(!used[j]) dfs(adj,used,order,j);
        }
        order.push(s);
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
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

