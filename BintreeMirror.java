/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.*;
public class Solution {
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur,tmp;
        while(!q.isEmpty()){
            cur = q.poll();
            tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if(cur.left!=null){
                q.offer(cur.left);
            }
            if(cur.right!=null){
                q.offer(cur.right);
            }
        }
    }
}