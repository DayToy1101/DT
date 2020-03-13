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
    int index = 0;
    private TreeNode rebuildTree(int[] inorder,int left,int right,int[] postorder){
        if(index < 0||left>=right){
            return null;
        }
        int inrootIdx = left;
        while(inrootIdx<right){
            if(inorder[inrootIdx]==postorder[index]){
                break;
            }
            inrootIdx++;
        }
        TreeNode root = new TreeNode(postorder[index]);
        --index;
        root.right = rebuildTree(inorder,inrootIdx+1,right,postorder);
        root.left = rebuildTree(inorder,left,inrootIdx,postorder);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        return rebuildTree(inorder,0,postorder.length,postorder);
    }
}