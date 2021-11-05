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
    void deleteNode(int key){
        Node temp = head, prev = null; // init Node temp as head, init Node prev as null
        if(temp != null && temp.data == key){ // if temp is not null and data of temp equals with key
            head = temp.next; //then, head = next of temp and return nothing (stop the procedure)
            return;
        }
        while(temp.next != null && temp.data != key){ // while next of temp is not null and data of temp doesn't equal with key
            prev = temp; //then, prev = temp
            temp = temp.next; // temp = next of temp (move every node)
        }
        if(temp == null) return; // if temp == null then return nothing (stop the procedure)
        prev.next = temp.next; // next of prev = next of temp
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
    boolean searchElement(Node node, int data){ // search Element in Linked List.
        Node newNode = node; // init Node newNode as node
        if(newNode == null) return false; // if newNode (node) is null then return false
        if(newNode.data == data) return true; // if data of newNode (node) equals data, then return true;
        return searchElement(newNode.next, data); // return searchElement (Recursively) with next of newNode
    }
    int searchElementIndex(Node node, int data){ // search Element index in Linked List
        Node newNode = node; // init Node newNode as node
        if(newNode == null) return 0; // if newNode (node) is null, then return 0
        if(newNode.data == data) return 0; //if data of newNode (node) equals data, then return 0
        return 1 + searchElementIndex(newNode.next, data); // return 1 + searchElementIndex (Recursively) with next of newnode
    }
    int searchElementAtIndex(Node node, int n){ // search Element at index
        Node newNode = node; // init Node newNode as node
        if(node == null) return -1; // if node is null, return -1;
        if(n == 0) return node.data; // if n equals 0
        return searchElementAtIndex(newNode.next, n-1); // return searchElementAtIndex (Recursively) with next of newNode (node) and n-1
    }
    int getNodeFromLast(int n){
        Node node = head; // init node as head
        
        /*
        int len = 0; // init len as 0 to find length of list
        while(node != null){ // while node is not null, then
            node = node.next; // node = node.next (move node to next node)
            len++; 
        }
        if (len <= n) return -1; // if length of list is smaller equal to n, then return -1
        node = head; // re init node as head (start from first index again)
        while(len-1 > n){ // while length of list -1 is bigger than n, then
            node = node.next; // node = node.next (move node to next node)
            len--; // decrement the len
        }
        */
        // another sample to find the length
        // we've made a function to find length of list, the function name was listLength()
        int len = listLength();
        if(len <= n) return -1;
        while(len-1 > n){
            node = node.next;
            len--;
        }
        return node.data; // return data of the node
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
	    linkedlist.append(50); //insert data from last Node
		linkedlist.append(60);
		linkedlist.printList();
		for(int i = 0; i < 7; i++){
		    if(linkedlist.getNodeFromLast(i) > -1) System.out.println("Data in Index of " + i + " from last is " + linkedlist.getNodeFromLast(i));
		    else System.out.println("Data in Index of " + i + " from last is not found");
		}
	}
}

