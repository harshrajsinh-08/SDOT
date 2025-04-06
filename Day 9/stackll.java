class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class stackll {
    private Node top;

    public stackll() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
    public int indexOf(int data) {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        Node temp = top;
        int index = 0;
        while (temp != null) {
            if (temp.data == data) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        System.out.println("Element not found in the stack");
        return -1;
    }
    public static void main(String[] args) {
        stackll stack = new stackll();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("TOP ELEMENT IS :"+ stack.peek());
        System.out.println("pop elemt is : "+stack.pop());
        stack.push(40);
        System.out.println("Index of 40 is : "+stack.indexOf(10));

    }
}
