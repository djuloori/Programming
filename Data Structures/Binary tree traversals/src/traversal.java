import java.io.IOException;
import java.util.*;

/**
 * Created by Dhruva Juloori on 7/31/2017.
 */
public class traversal {
 public static void main(String... args) throws IOException {
     new Thread(null, new Runnable() {
         public void run() {
             try {
                 new traversal().run();
             } catch (IOException e) {
             }
         }
     }, "1", 1 << 26).start();
 }

    public void run() throws IOException {
        build();
        inorder(BinaryTree.root);
        System.out.println();
        preorder(BinaryTree.root);
        System.out.println();
        postorder(BinaryTree.root);
    }

 static void build(){
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    BinaryTreeNode[] nodes = new BinaryTreeNode[n];
    for(int i = 0; i < nodes.length; i++){
        nodes[i] = new BinaryTreeNode();
        nodes[i].key = input.nextInt();
        nodes[i].left_index = input.nextInt();
        nodes[i].right_index = input.nextInt();
    }
    for(int i = 0; i < nodes.length; i++){
       if(nodes[i].left_index == -1 && nodes[i].right_index == -1){
           nodes[i].Left = null;
           nodes[i].Right = null;
       }else if(nodes[i].left_index == -1 && nodes[i].right_index != -1){
           nodes[i].Left = null;
           nodes[i].Right = nodes[nodes[i].right_index];
       }else if(nodes[i].left_index != -1 && nodes[i].right_index == -1){
           nodes[i].Left = nodes[nodes[i].left_index];
           nodes[i].Right = null;
       }else if(nodes[i].left_index != -1 && nodes[i].right_index != -1){
           nodes[i].Left = nodes[nodes[i].left_index];
           nodes[i].Right = nodes[nodes[i].right_index];
       }else{
           return;
       }
    }
     BinaryTree.root = nodes[0];
 }

  static void inorder(BinaryTreeNode root){
     if(root == null){
         return;
     }else {
        inorder(root.Left);
        System.out.print(root.key + " ");
        inorder(root.Right);
     }
 }


  static void preorder(BinaryTreeNode root){
     if(root == null){
         return;
     }else{
       System.out.print(root.key + " ");
       preorder(root.Left);
       preorder(root.Right);
     }
 }

    static void postorder(BinaryTreeNode root){
        if(root == null){
            return;
        }else{
          postorder(root.Left);
          postorder(root.Right);
          System.out.print(root.key + " ");
        }
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
