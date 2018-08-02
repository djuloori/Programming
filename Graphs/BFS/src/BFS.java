import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] distance = new int[adj.length];
        for(int i = 0; i < distance.length; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[s] = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int temp = queue.remove();
                if (temp == t) return distance[temp];
                process(queue, adj, temp, distance);
            }
        }
        return -1;
    }

    private static void process(Queue<Integer> queue, ArrayList<Integer>[] adj, int temp, int[] distance){
        for(int j : adj[temp]){
            if(distance[j]==Integer.MAX_VALUE) {
                queue.add(j);
                distance[j] = distance[temp] + 1;
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
        System.out.println(distance(adj, x, y));
    }
}


