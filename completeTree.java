/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;
        TreeNode cur = null;
        while(!q.isEmpty()){
            cur = q.poll();
            if(cur==null){
                flag = true;
                continue;
            }
            if(flag){
                return false;
            }
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return true;
    }
}