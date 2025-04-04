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

    public int getHeight(TreeNode node) {
        if (node == null) return -1;
        if (node.children.isEmpty()) return 0;

        int maxChildHeight = 0;
        for (TreeNode child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, getHeight(child));
        }
        return maxChildHeight + 1;
    }

    public int getTreeHeight() {
        return getHeight(root);
    }
}

public class GenericTreeHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter root node data: ");
        int rootData = scanner.nextInt();
        GenericTree tree = new GenericTree(rootData);

        System.out.print("Enter number of children for root: ");
        int numChildren = scanner.nextInt();
        for (int i = 0; i < numChildren; i++) {
            System.out.print("Enter data for child " + (i + 1) + ": ");
            int childData = scanner.nextInt();
            TreeNode childNode = new TreeNode(childData);
            tree.root.addChild(childNode);

            System.out.print("Enter number of children for node " + childData + ": ");
            int numGrandChildren = scanner.nextInt();
            for (int j = 0; j < numGrandChildren; j++) {
                System.out.print("Enter data for grandchild " + (j + 1) + " of node " + childData + ": ");
                int grandChildData = scanner.nextInt();
                TreeNode grandChildNode = new TreeNode(grandChildData);
                childNode.addChild(grandChildNode);
            }
        }

        System.out.println("Height of the tree: " + tree.getTreeHeight());
        scanner.close();
    }
}