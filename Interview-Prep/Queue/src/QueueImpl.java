public class QueueImpl implements Queue {
    Node ptr;
    Node ptr2;

    @Override
    public void push(int x) {
        if(ptr == null){
            Node n1 = new Node(x);
            ptr = n1;
            ptr2 = ptr;
        }else{
            Node n2 = new Node(x);
            ptr2.next = n2;
            ptr2 = n2;
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

    public static void main(String[] args){
        Queue Impl = new QueueImpl();
        Impl.push(1);
        Impl.push(2);
        Impl.push(3);
        Impl.push(4);
        Impl.push(5);
        Impl.peek();
        Impl.pop();
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
