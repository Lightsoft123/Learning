public class Main
{
    Node head, head2;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    void append(Node head, int data){
        Node newNode = new Node(data);
        Node findLast = head;
        if(head == null){
            return;
        }
        while(findLast.next != null){
            findLast = findLast.next;
        }
        findLast.next = newNode;
    }
    Node partitionLast(Node start, Node end){
        // if start equals end or start is nulll or end is null, then return start
        if(start == end || start == null || end == null) return start;
        // init pivot_prev as start
        Node pivot_prev = start;
        // init current as start
        Node current = start;
        //Node saveCurrent = current;
        // init pivot as data of end (last index of LinkedList)
        int pivot = end.data;
        // run start until end
        while(start != end){
            // if data of start is lesser than pivot (data of end(last index of LinkedList)), then
            if(start.data < pivot){
                pivot_prev = current; // set pivot_prev as current
                int temp = current.data; // init temp as data of current
                //System.out.println("current data : " + current.data);
                current.data = start.data; // data of current Node = data of start
                //System.out.println("Current data : " + current.data);
                start.data = temp; // data of start will be changed the lesser data into bigger data found from end
                current = current.next;
            }
            //System.out.print(start.data + "->");
            start = start.next;
        }
        //System.out.println();
        // swap data of current position
        int temp = current.data;
        //System.out.println("Temp : " + temp);
        //System.out.println("Current data : ");
        /*
        while(saveCurrent.next != null){
            System.out.print(saveCurrent.data + "->");
            saveCurrent = saveCurrent.next;
        }
        */
        //System.out.print(saveCurrent.data + "\n");
        current.data = pivot; 
        end.data = temp;
        return pivot_prev;
    }
    void sort(Node start, Node end){
        // if Node start is null or start equals end or start equals next of end, then return (stop procedure)
        if(start == null || start == end || start == end.next) return;
        // get pivot by running partitionLast function
        Node pivot_prev = partitionLast(start, end);
        //System.out.println("Pivot prev : " + pivot_prev.data);
        
        // re-call procedure of sort with parameter start and pivot_prev
        sort(start, pivot_prev);
        // if pivot_prev is not null and pivot_prev equals start, then
        // re-call procedure of sort with parameter next of pivot_prev(start)(because pivot_prev equals start) and end(last index)
        if(pivot_prev != null && pivot_prev == start) sort(pivot_prev.next, end);
        // if pivot_prev is not null and next of pivot_prev is not null
        // then re-call procedure of sort with parameter next of next pivot_prev and end(last index)
        else if(pivot_prev != null && pivot_prev.next != null) sort(pivot_prev.next.next, end);
    }
    void printList(Node head){
        Node newNode = head;
        while(newNode != null){
            if(newNode.next != null) System.out.print(newNode.data + "->");
            else System.out.print(newNode.data);
            newNode = newNode.next;
        }
    }
	public static void main(String[] args) {
		Main LinkedList = new Main();
		LinkedList.head = new Node(3);
		LinkedList.append(LinkedList.head, 20);
		LinkedList.append(LinkedList.head, 30);
		LinkedList.append(LinkedList.head, 5);
		LinkedList.append(LinkedList.head, 10);
		System.out.print("Linked List 1 before sorting : ");
        LinkedList.printList(LinkedList.head);
        System.out.println();
        Node n = LinkedList.head;
        while(n.next != null){
            n = n.next;
        }
        LinkedList.sort(LinkedList.head, n);
        System.out.print("Linked List 1 after sorting : ");
        LinkedList.printList(LinkedList.head);
		LinkedList.head2 = new Node(3);
		LinkedList.append(LinkedList.head2, 1);
OAOAOA		LinkedList.append(LinkedList.head2, 15);
OA		LinkedList.append(LinkedList.head2, 4);
OAOA		LinkedList.append(LinkedList.head2, 10);
OA		System.out.print("\nLinked List 2 before sorting : ");
		LinkedList.printList(LinkedList.head2);
		n = LinkedList.head2;
OA		while(n.next != null){
OAOA		    n = n.next;
		}
OA		LinkedList.sort(LinkedList.head2, n);
OAOA		System.out.print("\nLinked List 2 after sorting : ");
		LinkedList.printList(LinkedList.head2);
	}
OAOA}

