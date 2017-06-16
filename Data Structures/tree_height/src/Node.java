import java.util.*;

/**
 * Created by Dhruva Juloori on 6/14/2017.
 */
public class Node {
    ArrayList<Node> children = new ArrayList<>();
    int height = 1;

    public Node(){}

    public void addchildren(Node node){
        this.children.add(node);
    }

    static int get_height(Node root){
        int height = 0;
        if(root == null){
            return height;
        }else{
            Queue<Node> q = new LinkedList<>();
            root.height = 1;
            q.add(root);
            while(q.size()!=0){
                Node temp = q.remove();
                 height = temp.height;
                if(temp.children.isEmpty()){
                    continue;
                }else{
                    for (int i = 0; i < temp.children.size(); i++){
                        temp.children.get(i).height = temp.height + 1;
                        q.add(temp.children.get(i));
                    }
                }
            }
            return height;
        }
    }


    public static void read(){
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        Node[] nodes;
        nodes = new Node[(int)n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node();
        }
        long root = 0;
        for(long child_index = 0; child_index < n; child_index++){
            long parent_index = input.nextLong();
            if(parent_index == -1){
                root = child_index;
            }else{
                nodes[(int)parent_index].addchildren(nodes[(int)child_index]);
            }
        }
        System.out.println(get_height(nodes[(int) root]));
    }


    public static void main(String[] args) {
        read();
    }
}
