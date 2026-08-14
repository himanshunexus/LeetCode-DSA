class Solution {
    public int sumDigit(TreeNode root , int prev){
        if(root == null) return 0;
        prev = prev * 10 + root.val;
        if(root.left == null && root.right == null) return prev;
        return sumDigit(root.left , prev) + sumDigit(root.right , prev);
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return sumDigit(root , 0);
    }
}
