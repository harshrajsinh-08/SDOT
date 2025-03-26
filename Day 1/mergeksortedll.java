import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class mergeksortedll {

    static Node mergeKLists(ArrayList<Node> listArray) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.data));

        for (Node node : listArray) {
            if (node != null) {
                pq.add(node);
            }
        }

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (!pq.isEmpty()) {
            Node minNode = pq.poll();
            tail.next = minNode;
            tail = minNode;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }

    static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(2, new Node(4, new Node(6)));
        Node head2 = new Node(1, new Node(5));
        Node head3 = new Node(1, new Node(1, new Node(3, new Node(7))));
        Node head4 = new Node(8);

        ArrayList<Node> lists = new ArrayList<>(Arrays.asList(head1, head2, head3, head4));

        System.out.println("Original Linked Lists:");
        for (int i = 0; i < lists.size(); i++) {
            System.out.print("List " + (i + 1) + ": ");
            printLinkedList(lists.get(i));
        }

        Node mergedList = mergeKLists(lists);
        System.out.print("Merged Linked List: ");
        printLinkedList(mergedList);
    }
}
