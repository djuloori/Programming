public class StackImpl implements Stack{
   Node ptr = null;

    @Override
    public void push(int x) {
        if(ptr == null){
          Node n1 = new Node(x);
          ptr = n1;
        }else{
         Node n2 = new Node(x);
         n2.next = ptr;
         ptr = n2;
        }
    }

    @Override
    public void peek() {
        System.out.println("peek" + " " + ptr.data);
    }

    @Override
    public void pop() {
        System.out.println("pop" + " " + ptr.data);
        ptr = ptr.next;
    }

    public static void main(String args[]){
        Stack Impl = new StackImpl();
        Impl.push(1);
        Impl.push(2);
        Impl.push(3);
        Impl.push(4);
        Impl.push(5);
        Impl.peek();
        Impl.pop();
        Impl.peek();
        Impl.push(5);
        Impl.peek();
    }

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
}



