import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Dhruva Juloori on 8/12/2017.
 */
public class search_tree {
    public static void main(String... args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new search_tree().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        build();
    }

    static void build(){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n == 0){
            System.out.println("CORRECT");
        }else {
            BinaryTreeNode[] nodes = new BinaryTreeNode[n];
            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new BinaryTreeNode();
                nodes[i].key = input.nextInt();
                nodes[i].left_index = input.nextInt();
                nodes[i].right_index = input.nextInt();
            }
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i].left_index == -1 && nodes[i].right_index == -1) {
                    nodes[i].Left = null;
                    nodes[i].Right = null;
                } else if (nodes[i].left_index == -1 && nodes[i].right_index != -1) {
                    nodes[i].Left = null;
                    nodes[i].Right = nodes[nodes[i].right_index];
                } else if (nodes[i].left_index != -1 && nodes[i].right_index == -1) {
                    nodes[i].Left = nodes[nodes[i].left_index];
                    nodes[i].Right = null;
                } else if (nodes[i].left_index != -1 && nodes[i].right_index != -1) {
                    nodes[i].Left = nodes[nodes[i].left_index];
                    nodes[i].Right = nodes[nodes[i].right_index];
                } else {
                    return;
                }
            }
            BinaryTree.root = nodes[0];
            inorder(BinaryTree.root);
            evaluation();
        }
    }

    static ArrayList<Integer> elements = new ArrayList<>();
    static int temp = Integer.MIN_VALUE;
    static void inorder(BinaryTreeNode root){
        if(root == null){
            return;
        }else {
            inorder(root.Left);
            elements.add(root.key);
            inorder(root.Right);
        }
    }

    static void evaluation(){
        for(int i = 0; i < elements.size(); i++){
            if(elements.get(i) > temp){
                temp = elements.get(i);
            }else{
                System.out.println("INCORRECT");
                return;
            }
        }
        System.out.println("CORRECT");
    }

    static class BinaryTreeNode{
        int key;
        int left_index;
        int right_index;
        BinaryTreeNode Left;
        BinaryTreeNode Right;
    }

    static class BinaryTree{
        static BinaryTreeNode root;
    }
}
