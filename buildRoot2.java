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
    //preorder:前序遍历结果
    //inorder:中序遍历结果
    //[left,right)：标记树中节点在inorder中的范围
    int index = 0;
    private TreeNode reBuildTree(int[] preorder,int[] inorder,int left,int right){
        if(index > preorder.length || left >= right){
            return null;
        }
        //前序中找根节点
        //preorder[0];
        //创建根节点
        //TreeNode root = new TreeNode(preorder[index]);
        
        //在中序遍历结果中找根的位置
        int inrootIdx = left;
        while(inrootIdx<right){
            if(preorder[index] == inorder[inrootIdx] ){
                break;
            }
            inrootIdx++;
        }
         //创建根节点
        TreeNode root = new TreeNode(preorder[index]);

        ++index;
        //递归创建根节点的左子树
        root.left = reBuildTree(preorder,inorder,left,inrootIdx);
        
        //递归创建根节点的右子树
        root.right = reBuildTree(preorder,inorder,inrootIdx+1,right);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return reBuildTree(preorder,inorder,0,inorder.length);
    }
}