class Solution {
    public boolean isOneP(TreeNode root){
        if(root == null) return false;
        if(root.val == 1) return true;
        return isOneP(root.left) || isOneP(root.right);
    }
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;

        if(!isOneP(root.left)) root.left = null;
        if(!isOneP(root.right)) root.right = null;

        pruneTree(root.left);
        pruneTree(root.right);

        if(root.left == null && root.right == null && root.val == 0)
            return null;
        
        return root;
    }
}
