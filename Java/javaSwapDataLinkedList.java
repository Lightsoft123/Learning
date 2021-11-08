/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

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
    boolean swapData(Node node, int data1, int data2){ // function swap data and return bool
        Node newNode1 = node; // init newNode1 as node
        Node prevNode1 = null; // init previous of newNode1 as null
        // find if data of newNode1 equals data1
        while(newNode1.data != data1 && newNode1 != null){
            Node newNodee1 = newNode1.next;
            if(newNodee1.data == data1) prevNode1 = newNode1; 
            newNode1 = newNode1.next;
        }
        Node newNode2 = node; // init newNode2 as node
        Node prevNode2 = null; // init previous of newNode2 as null
        // find if data of newNode2 equals data2
        while(newNode2.data != data2 && newNode2 != null){
            Node newNodee2 = newNode2.next;
            if(newNodee2.data == data2) prevNode2 = newNode2;
            newNode2 = newNode2.next;
        }
        if(newNode1 == null || newNode2 == null) return false; // if both data is not found, return false
        if(prevNode1 == null && prevNode2 == null) return false; // if previous of both data is not found, return false
        if(prevNode1 != null && prevNode2 != null){ // if both data is found, then
            Node newNode3 = newNode2.next; // set newNode3 as next of newNode2
            prevNode1.next = newNode2; // change next of previous newNode1 as newNode2
            newNode2.next = newNode1.next; // change next of newNode2 as next of newNode1
            prevNode2.next = newNode1; // change next of previous newNode2 as newNode1
            newNode1.next = newNode3; // change next of newNode1 as newNode3 (next of newNode2 before changed)
            return true; // then return true to prove it if the swap has been successful
        }
        // if previous of Node1 or Node2 is found null (not both is null), then one of them is head
        else{
            if(prevNode1 == null){
                // because of previous of Node1 is null, it means Node1 is head.
                // when we swap it, we must re-init head as Node2 (Node2 is Node1 position after swap).
                // Because, head is Node1 and Node1 position has changed.
                Node newNode3 = newNode1.next;
                newNode1.next = newNode2.next;
                prevNode2.next = newNode1;
                newNode2.next = newNode3;
                head = newNode2;
                return true;
            }
            else{
                // because of previous of Node2 is null, it means Node2 is head.
                // when we swap it, we must re-init head as Node1 (Node1 is Node2 position after swap).
                // Because, head is Node2 and Node2 position has changed.
                Node newNode3 = newNode2.next;
                newNode2.next = newNode1.next;
                prevNode1.next = newNode2;
                newNode1.next = newNode3;
                head = newNode1;
                return true;
            }
        }
    }
    void printList(Node head){
        Node n = head; //init n as head
        while(n != null){ //while n is not null, then print data from n class (node class).
            if(n.next != null) System.out.print(n.data + "->");
            else System.out.print(n.data);
            n = n.next; //move by access the next var from n class
        }
    }
	public static void main(String[] args) {
	    Main linkedlist = new Main();
		Node first = new Node(5);
		Node second = new Node(6);
		Node third = new Node(3);
		linkedlist.head = first; //can access outside of Node class/object
		linkedlist.head.next = second;
	    second.next = third; 
	    linkedlist.append(linkedlist.head, 50);
	    linkedlist.append(linkedlist.head, 60);
		System.out.print("Linked List : ");
		linkedlist.printList(linkedlist.head);
        System.out.print("\nLinked List After Swap : ");
        if(linkedlist.swapData(linkedlist.head, 5, 60)) linkedlist.printList(linkedlist.head);
        else System.out.println("Swap Failed");
	}
}

