class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean past = false;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                past = true;
            }
            else{
                if(past == true){
                    return false;
                }
                else{
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return true;
    }
}
