import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    int data;
    List<TreeNode> children;

    public TreeNode(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }
}

class GenericTree {
    TreeNode root;

    public GenericTree(int rootData) {
        this.root = new TreeNode(rootData);
    }

    public int sumTree(TreeNode node) {
        if (node == null) return 0;

        int sum = node.data;
        for (TreeNode child : node.children) {
            sum += sumTree(child);
        }
        return sum;
    }

    public int getTotalSum() {
        return sumTree(root);
    }
}

public class GenericTreeSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter root node data: ");
        int rootData = scanner.nextInt();
        GenericTree tree = new GenericTree(rootData);

        System.out.print("Enter the number of children for root: ");
        int numChildren = scanner.nextInt();
        addChildren(tree.root, numChildren, scanner);

        System.out.println("Total sum of all nodes: " + tree.getTotalSum());
    }

    private static void addChildren(TreeNode parent, int numChildren, Scanner scanner) {
        for (int i = 0; i < numChildren; i++) {
            System.out.print("Enter data for child " + (i + 1) + " of node " + parent.data + ": ");
            int childData = scanner.nextInt();
            TreeNode child = new TreeNode(childData);
            parent.addChild(child);

            System.out.print("Enter the number of children for node " + childData + ": ");
            int childCount = scanner.nextInt();
            addChildren(child, childCount, scanner);
        }
    }
}