import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
class validbst {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        Stack <TreeNode> st = new Stack<>();
        TreeNode prev=null;
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr = st.pop();
            if(prev!=null && prev.val>=curr.val){
                return false;
            }
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
    public static void main(String[] args) {
        validbst p = new validbst();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(p.isValidBST(root)); 

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println(p.isValidBST(root2)); 
    }
}
