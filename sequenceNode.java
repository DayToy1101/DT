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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null){
            return ret;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            //队列中保存的就是一层的节点
            //一次性将该层的节点全部遍历完
            int size = q.size();
            List<Integer> level = new ArrayList<>(size);
            for(int i = 0;i<size;i++){
                TreeNode cur = q.poll();
                level.add(cur.val);

                //如果有左孩子，将左孩子入队列
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                //
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}