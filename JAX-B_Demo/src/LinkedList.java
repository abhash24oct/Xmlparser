class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next= null;
    }
}
public class LinkedList {
    Node head;

    public   void push(int data){

        Node n = new Node(data);
        if(head==null){
            head =n;
        }else{
            Node temp = head;
            while(temp.next!=null){
                temp= temp.next;
            }
            temp.next=n;
        }
    }

    public void append(int data){
        Node n = new Node(data);
        Node temp=head;
        head = n;
        head.next=temp;

    }

    public void insertAfter(int data){
        Node n = new Node(data);
    }
    public void printLislt(){
        if(head==null){
            System.out.println("Empty");
        }else{
                Node n= head;
                while(n!=null){
                    System.out.print(n.data+"--->");
                    n=n.next;
                }
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.push(18);
        l.push(20);
        l.append(12);
        l.push(30);
        l.append(10);
        l.printLislt();
    }
}
