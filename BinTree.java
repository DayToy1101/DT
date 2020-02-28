
//二叉树采用孩子表示法
class BTNode{
    BTNode left = null;//指向该节点的左孩子
    BTNode right = null;//指向该节点的右子树
    int val;
    public BTNode(int val){
        this.val=val;
    }
}

public class BinTree {
    private BTNode root= null;//引用二叉树的根节点

    //遍历操作：将节点中的值域打印出来
    //前序遍历:根节点--》根节点的左子树--》根节点的右子树
    public void preOrder(BTNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    //中序遍历：根节点的左子树--》根节点--》根节点的右子树
    public void inOrder(BTNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+" ");
            inOrder(root.right);
        }
    }
    //后序遍历：根节点的左子树--》根节点的右子树--》根节点
    public void postOrder(BTNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val+" ");
        }
    }
    public static void main(String[] args) {

    }

}
