/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void preorder(TreeNode var,ArrayList<Integer> list){
        if(var == null){
            list.add(null);
            return;
        }
        list.add(var.val);
        preorder(var.left,list);
        preorder(var.right,list);
        
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> listOne = new ArrayList<>();
        ArrayList<Integer> listTwo = new ArrayList<>();
        preorder(p,listOne);
        preorder(q,listTwo);
        return listTwo.equals(listOne);
    }
}
