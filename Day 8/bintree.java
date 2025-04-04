import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class bintree {
    public static Node createTreeFromArray(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }

        Node node = new Node(arr[index]);
        node.left = createTreeFromArray(arr, 2 * index + 1);
        node.right = createTreeFromArray(arr, 2 * index + 2);

        return node;
    }

    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -1, 4, 5, 6};
        Node root = createTreeFromArray(arr, 0);
        System.out.println("TRee : ");

        System.out.println("In-order traversal of the binary tree:");
        inOrderTraversal(root);
    }
}
