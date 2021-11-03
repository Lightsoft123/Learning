import java.util.*;

public class Main
{
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    void push(int data){
        Node newData = new Node(data); //init newData as new Node of Data
        newData.next = head; // init next of newData node as head
        head = newData; // make newData as head Node
        //it works for pushing data from head
    }
    void insertAfterNode(Node prevNode, int newData){
        if(prevNode == null) //if you want to insert data after node, the previous node must not be null
            System.out.println("Previous Node cannot be null");
        Node newNodeData = new Node(newData); //init newNodeData as new Node of newData var
        newNodeData.next = prevNode.next; // init next of newNodeData as prevNode.next (change position of next)
        prevNode.next = newNodeData; //make next of prevNode as newNodeData node
    }
    void append(int newData){
        Node newNodeData = new Node(newData); // init newNodeData as new Node of newData
        if(head == null){ // if head is null (linkedlist is still empty), then head = Node of newNodeData and return nothing
            head = newNodeData;
            return;
        }
        Node findLast = head; // init findLast node as head
        while(findLast.next != null){ // while findLast.next is not null, then findLast = next of findLast (move every node)
            findLast = findLast.next;
        }
        newNodeData.next = null; // init next of newNodeData node as null
        // after found the node is null, then findLast.next = newNodeData
        findLast.next = newNodeData;
    }
    void printList(){
        Node n = head; //init n as head
        while(n != null){ //while n is not null, then print data from n class (node class).
            System.out.println(n.data + " ");
            n = n.next; //move by access the next var from n class
        }
    }
	public static void main(String[] args) {
		Main linkedlist = new Main();
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		linkedlist.head = first; //can access outside of Node class/object
		linkedlist.head.next = second;
	    second.next = third; //cannot access outside of Node class/object, means cannot access the head. So, just access the next (like tail)
		third.next = null;
		linkedlist.push(5); // add element from head
		linkedlist.insertAfterNode(second, 293); // insert data from Node second
		linkedlist.append(50); //insert data from last Node
		linkedlist.append(60);
		linkedlist.printList();
	}
}

