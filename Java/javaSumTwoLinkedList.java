import java.util.*;

public class Main
{
    Node head1, head2, head3;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    void append(Node head, int newData){
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
    void deleteLinkedList(Node head){
        head = null;
    }
    int listLengthRecord(Node head){
        if(head == null) return 0; //if head Node is null, then return 0
        return 1 + listLengthRecord(head.next); // else return 1 + listLengthRecord(head.next)
    }
    int listLength(Node head){
        return listLengthRecord(head);
    }
    String joinEveryNodes(Node head){ // convert Linked List data to string Recursively
        if(head == null) return "";
        return "" + head.data + joinEveryNodes(head.next);
    }
    int sumTwoNodes(Node head1, Node head2){
        if(head1 == null || head2 == null) return 0; // if head1 or head2 is null, return 0
        //Convert Linked List from head1 and head2 to string and then convert it to integer and sum it both
        int result = Integer.parseInt(joinEveryNodes(head1));
        result += Integer.parseInt(joinEveryNodes(head2));
        return result;
    }
    void printList(Node head){
        Node n = head; //init n as head
        while(n != null){ //while n is not null, then print data from n class (node class).
            if(n.next != null) System.out.print(n.data + " -> ");
            else System.out.print(n.data);
            n = n.next; //move by access the next var from n class
        }
    }
    void printSumList(int sum){
        // init array int to save result for every number
        int[] save = new int[10005];
        int i = 0; // init i as 0
        // get all numbers and save every numbers in array int
        while(sum > 0){
            save[i++] = sum % 10;
            sum /= 10;
        }
        Node[] newNode = new Node[i]; // declare new array of Node
        head3 = new Node(save[i-1]);
        // set head3 as new Node of first number in array
        // actually if want to do first number, usually use array at 0 index
        // but, because we do sum % 10 and it detects numbers from back.
        // So, the first number is at last index of array
        int k = 0;
        // set all saved numbers to a new node
        for(int j = i-2; j >= 0; j--){
            newNode[k++] = new Node(save[j]);
        }
        // then, connect every nodes with next of node
        for(int j = 0; j < k-1; j++){
            newNode[j].next = newNode[j+1];
        }
        // then, connect head to first of newNode to get all data connections
        head3.next = newNode[0];
        // init move as head3 to avoid head3 moving
        Node move = head3;
        // run every node of move (head3) and print every nodes data
        while(move != null){
            if(move.next == null) System.out.print(move.data);
            else System.out.print(move.data + " -> ");
            move = move.next;
        }
    }
	public static void main(String[] args) {
		Main linkedlist = new Main();
		Node first = new Node(5);
		Node second = new Node(6);
		Node third = new Node(3);
		linkedlist.head1 = first; //can access outside of Node class/object
		linkedlist.head1.next = second;
	    second.next = third; //cannot access outside of Node class/object, means cannot access the head. So, just access the next (like tail)
	    //linkedlist.append(linkedlist.head1, 4); //insert data from last Node
		//linkedlist.append(linkedlist.head1, 6);
		System.out.print("First Linked List :");
		linkedlist.printList(linkedlist.head1);
		
		linkedlist.head2 = new Node(8);
		linkedlist.head2.next = new Node(4);
		linkedlist.head2.next.next = new Node(2);
		System.out.print("\nSecond Linked List :");
		linkedlist.printList(linkedlist.head2);
		//System.out.println("\nSUM : " + linkedlist.sumTwoNodes(linkedlist.head1, linkedlist.head2));
		System.out.print("\nSum List : ");
		linkedlist.printSumList(linkedlist.sumTwoNodes(linkedlist.head1, linkedlist.head2));
	}
}

