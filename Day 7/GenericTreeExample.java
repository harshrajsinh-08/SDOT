import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {
    String data;
    List<TreeNode> children;

    public TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public void display(String prefix) {
        System.out.println(prefix + data);
        for (TreeNode child : children) {
            child.display(prefix + "--");
        }
    }
}

class GenericTree {
    TreeNode root;

    public GenericTree(String rootData) {
        this.root = new TreeNode(rootData);
    }

    public void displayTree() {
        if (root != null) {
            root.display("");
        }
    }
}

public class GenericTreeExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter root node data: ");
        String rootData = scanner.nextLine();
        GenericTree tree = new GenericTree(rootData);

        addChildren(scanner, tree.root);

        System.out.println("\nTree Structure:");
        tree.displayTree();
    }

    private static void addChildren(Scanner scanner, TreeNode node) {
        System.out.print("Enter the number of children for " + node.data + ": ");
        int numChildren = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numChildren; i++) {
            System.out.print("Enter data for child " + (i + 1) + " of " + node.data + ": ");
            String childData = scanner.nextLine();
            TreeNode child = new TreeNode(childData);
            node.addChild(child);

            addChildren(scanner, child);
        }
    }
}
