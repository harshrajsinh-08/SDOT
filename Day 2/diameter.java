class diameter {
    public int diameterOfBinaryTree(TreeNode root) {
      maxDepth(root);
      return ans;
    }
  
    private int ans = 0;
  
    int maxDepth(TreeNode root) {
      if (root == null) return 0;
      int l = maxDepth(root.left);
      int r = maxDepth(root.right);
      ans = Math.max(ans, l + r);
      return 1 + Math.max(l, r);
    }
}