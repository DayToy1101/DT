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
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null||root2==null){
            return false;
        }
        if(isSameTree(root1,root2)){
            return true;
        }
        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }
    private boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(q==null){
            return true;
        }
        if(p==null&&q!=null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}