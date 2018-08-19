import java.util.*;

public class Bipartite {

    private static int bipartite(ArrayList<Integer>[] adj) {
        Map<Integer,String> tracker = new HashMap<>();
        Queue<Integer> track = new LinkedList<>();
        tracker.put(0,"Black");
        track.add(0);
        while(!track.isEmpty()){
            Integer temp = track.remove();
            for(int i : adj[temp]){
                if(tracker.containsKey(i)){
                     if(tracker.get(i).equals(tracker.get(temp))) return 0;
                }else{
                    if(tracker.get(temp).equals("Black")){
                        tracker.put(i,"White");
                    }else{
                        tracker.put(i,"Black");
                    }
                    track.add(i);
                }
            }

        }
        return 1;
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
        System.out.println(bipartite(adj));
    }
}

