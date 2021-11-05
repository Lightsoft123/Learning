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
    void deleteNodeBasedOnPosition(int position){
        if(head == null){ // if Node head is null, then return (stop procedure)
            return;
        }
        Node temp = head; // init Node temp as head
        if(position == 0){ // if position is 0, then head = next of temp and return nothing (stop procedure)
            head = temp.next;
            return;
        }
        int i = 0;
        while(i < position && temp.next != null){ // while i is less than position and next of temp is not null
            i++; // then move i
            if(i == position) break; // if i equals position, then break
            temp = temp.next; // move temp
        }
        if(temp == null || temp.next == null) return; // if temp is null and next of temp is null, then return (stop position)
        Node Next = temp.next.next; // init Node next as the next of next temp
        temp.next = Next; // init temp.next as Next
    }
    void deleteLinkedList(){
        head = null;
    }
    int listLengthRecord(Node head){
        if(head == null) return 0; //if head Node is null, then return 0
        return 1 + listLengthRecord(head.next); // else return 1 + listLengthRecord(head.next)
    }
    int listLength(){
        return listLengthRecord(head);
    }
    int searchElementAtIndex(Node node, int n){ // search Element at index
        Node newNode = node; // init Node newNode as node
        if(node == null) return -1; // if node is null, return -1;
        if(n == 0) return node.data; // if n equals 0
        return searchElementAtIndex(newNode.next, n-1); // return searchElementAtIndex (Recursively) with next of newNode (node) and n-1
    }
    int getMiddleElement(){
        Node slow_ptr = head; // init slow_ptr as head
        Node fast_ptr = head; // init fast_ptr as head
        if(head == null) return -1; // if head is null, then return -1
        while(fast_ptr != null && fast_ptr.next != null){ // while fast_ptr is not null and the next node of fast_ptr is not null, then
            fast_ptr = fast_ptr.next.next; // fast_ptr = next node of next node of fast_ptr
            slow_ptr = slow_ptr.next; // slow_ptr = next node of slow_ptr
        }
        return slow_ptr.data; // return data from slow_ptr node
    }
    int numberOfTimesData(Node node, int key){
        Node newNode = node; // init newNode as node
        int count = 0; // init count to count number of data equals key
        if(node == null) return 0; // if node is null, then return 0
        while(newNode != null){ // while newNode is not null, then
            if(newNode.data == key) count++; // if data of newNode equals key, increment count
            newNode = newNode.next; // newNode = next of newNode (move node to next one)
        }
        return count; // return count
    }
    void printList(){
        Node n = head; //init n as head
        while(n != null){ //while n is not null, then print data from n class (node class).
            System.out.println(n.data + " ");
            n = n.next; //move by access the next var from n class
        }
    }
    void printList2(Node node){
        Node newNode = node;
        while(newNode != null){
            System.out.print(newNode.data + "->");
            newNode = newNode.next;
        }
        System.out.println("NULL");
    }
	public static void main(String[] args) {
		Main linkedlist = new Main();
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		linkedlist.head = first; //can access outside of Node class/object
		linkedlist.head.next = second;
	    second.next = third; //cannot access outside of Node class/object, means cannot access the head. So, just access the next (like tail)
	    linkedlist.append(50); //insert data from last Node
		linkedlist.append(60);
		linkedlist.append(50);
		linkedlist.append(2);
		linkedlist.append(50);
		linkedlist.printList();
	    linkedlist.printList2(linkedlist.head);
	    System.out.println("The Middle Element is " + linkedlist.getMiddleElement());
	    System.out.println("Number of 50 is " + linkedlist.numberOfTimesData(linkedlist.head, 50) + " times");
	}
}

