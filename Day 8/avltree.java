import java.util.Scanner;

class avltree {
    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }
    public Node root;

    int height(Node N) {
        return (N == null) ? 0 : N.height;
    }

    int getbal(Node N) {
        return (N == null) ? 0 : height(N.left) - height(N.right);
    }

    Node rrot(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node lrot(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getbal(node);

        if (balance > 1 && key < node.left.key)
            return rrot(node);

        if (balance < -1 && key > node.right.key)
            return lrot(node);

        if (balance > 1 && key > node.left.key) {
            node.left = lrot(node.left);
            return rrot(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rrot(node.right);
            return lrot(node);
        }

        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    public void preOrder() {
        preOrder(root);
    }

    public static void main(String[] args) {
        avltree tree = new avltree();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements to insert:");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            tree.insert(key);
        }

        System.out.println("Preorder traversal of the AVL tree:");
        tree.preOrder();
    }
}
