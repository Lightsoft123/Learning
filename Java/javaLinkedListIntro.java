import java.util.*;

public class Main
{
    Node head; // declare head as Node variable (Node variable is gotten by built a class)
    public static class Node{
        int data; // declare data as integer variable
        Node next; // declare next as Node variable (Node is gotten from itself class)
        //build constructor to make a new Node data
        Node(int data){
            this.data = data; // init data from Node parameter, and pass out to declared data outside constructor
            next = null; // init next as null for every new declared object. when the data is inserted, the "next" variable will be the next index
        }
    }
    public void printList(){
        Node n = head; // init n as head
        while(n != null){ //while n (head) is not null :
                            // print data of n (head)
            System.out.println(n.data + " ");
            n = n.next; // move n by giving next of n(head) value. it means : every data printed, the head (n) will be moved to next Node
        }
    }
	public static void main(String[] args) {
	    Main lList = new Main();
	    lList.head = new Node(1);
	    Node[] num = new Node[5];
	    for(int i = 1; i <= 4; i++){
	        num[i] = new Node(3+i);
	    }
	    lList.head.next = num[1];
	    for(int i=1; i <= 3; i++){
	        num[i].next = num[i+1];
	    }
	    num[4].next = null;
	    lList.printList();
	}
}

