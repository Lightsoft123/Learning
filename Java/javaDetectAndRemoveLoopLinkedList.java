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
    boolean detectAndRemoveLoop(Node node){
        Node slow = node; // init slow as node
        Node fast = node; // init fast as node
        while(slow != null && fast != null && fast.next != null){ // while slow and fast and next of fast is not null
            slow = slow.next; // slow = next of slow (move node);
            fast = fast.next.next; // fast = next of next of fast (move node faster)
            if(slow == fast){ // if slow equals fast, then remove Loop with parameter slow and node and return true
                removeLoop(slow, node);
                return true;
            }
        }
        return false; // if doesnt require any from above, then return false (didn't find loop)
    }
    void removeLoop(Node loop, Node head){
        // init 2 nodes as loop
        Node ptr1 = loop;
        Node ptr2 = loop;
        int k = 1;
        // find range between ptr1 to ptr2 with k
        while(ptr1.next != ptr2){ // while next of ptr1 is not equal to ptr2, then ptr1 = next of ptr1 (move node)
            ptr1 = ptr1.next;
            k++; // increment k
        }
        // re-init ptr1 and ptr2 as head
        ptr1 = head; // start back from 0
        ptr2 = head;
        for(int i = 0; i < k; i++){
            ptr2 = ptr2.next; // take the pointer of last node (looping node)
        }
        //next both nodes until found the same points
        while(ptr1 != ptr2){ // while ptr1 is not equal to ptr2, then move ptr1 and ptr2
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        // while next of ptr2 is not equal to ptr1, then ptr2 move to next one
        while(ptr2.next != ptr1){
            ptr2 = ptr2.next;
        }
        // after ptr2.next is found (equals with ptr1), then set ptr2.next as null
        ptr2.next = null;
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
	    linkedlist.append(50); //insert data from last Node
		linkedlist.append(60);
		linkedlist.append(50);
		linkedlist.append(2);
		linkedlist.append(50);
		linkedlist.printList();
		third.next = linkedlist.head.next;
		System.out.println(linkedlist.detectAndRemoveLoop(linkedlist.head));
		linkedlist.printList();
	}
}

