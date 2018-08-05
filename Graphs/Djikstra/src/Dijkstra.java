import java.util.*;

public class Dijkstra {
    static class Node implements Comparable<Node>{
        int index;
        int distance;

        public Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance > o.distance) return 1;
            else if (this.distance < o.distance) return -1;
            else return 0;
        }
    }


    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int[] tracker = new int[adj.length];
        for(int i = 0; i < tracker.length; i++){
            tracker[i] = Integer.MAX_VALUE;
        }
        tracker[s] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s,tracker[s]));
        while (!pq.isEmpty()){
            Node temp = pq.remove();
            int index = temp.index;
            for(int j : adj[index]){
                int c = adj[index].indexOf(j);
                if(tracker[j] > tracker[index] + cost[index].get(c)){
                    tracker[j] = tracker[index] + cost[index].get(c);
                    pq.add(new Node(j,tracker[j]));
                }
            }

        }
        return tracker[t]==Integer.MAX_VALUE?-1:tracker[t];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

