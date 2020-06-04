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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur=root;
        TreeNode ret = null;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0;i<len;i++){
                ret = q.poll();
                if(i==len-1){
                    list.add(ret.val);
                }
                if(ret.left!=null){
                    q.offer(ret.left);
                }
                if(ret.right!=null){
                    q.offer(ret.right);
                }
            }
            
        }
        return list;
    }
}