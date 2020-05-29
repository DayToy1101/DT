//binary search tree
public class BSTree {
    public static class BSTNode{
        BSTNode left = null;
        BSTNode right = null;
        int val;
        BSTNode(int val){
            this.val = val;
        }
    }
    private BSTNode root = null;
    //检测val是否在二叉搜索树中
    boolean contains(int val){
        BSTNode cur = root;
        while(cur!=null){
            if(cur.val == val){
                return true;
            }
            else if(cur.val < val){
                cur = cur.right;
            }
            else{
                cur = cur.left;
            }
        }
        return false;
    }
    //将val插入到二叉搜索树中，插入成功返回true，否则返回false
    public boolean put(int val){
        //空树
        if(root==null){
            root = new BSTNode(val);
            return true;
        }
        //树非空
        //找待插入元素在二叉搜索树中的插入位置,并保存其双亲
        BSTNode cur = root;
        BSTNode parent = null;
        while(cur != null){
            parent = cur;
            if(cur.val < val){
                cur = cur.right;
            }
            else if(cur.val > val){
                cur = cur.left;
            }
            else{
                return false;
            }
        }
        //找到待插入节点的位置---插入新节点
        //将新节点插入到parent的左侧或者右侧
        cur = new BSTNode(val);
        if(val < parent.val){
            parent.left = cur;
        }else{
            parent.right = cur;
        }
        return true;
    }
    //找树中最小的节点
    public int leftMost(){
        if(root==null){
            //抛异常
            ;
        }
        BSTNode cur = root;
        while(cur.left!=null){
            cur=cur.left;
        }
        return cur.val;
    }
    //找树中最大的节点
    public int rightMost(){
        if(root==null){
            //抛异常
            ;
        }
        BSTNode cur = root;
        while(cur.right!=null){
            cur=cur.right;
        }
        return cur.val;
    }
    //删除节点
    boolean remove(int val){
        if(root == null){
            return false;
        }
        //非空
        //找待删除节点的位置
        BSTNode cur =root;
        BSTNode parent = null;
        while(cur!=null){
            if(val == cur.val){
                break;
            }
            else if(cur.val < val){
                parent = cur;
                cur = cur.right;
            }
            else{
                parent = cur;
                cur = cur.left;
            }
        }
        //没找到，该节点不在树中
        if(cur==null){
            return false;
        }
        //已找到带删除节点的位置----删除该节点
        //对删除节点的左右孩子分情况
        /**
         * 删除的是叶子结点，左右孩子均不存在
         * 删除的节点只有右孩子
         * 删除的节点只有左孩子
         * 删除的节点左右孩子均存在
         * 对于要删除的节点还要判断该节点是否有双亲，是双亲的左孩子还是右孩子
         */
        if(cur.left == null){
            //cur只有右孩子||cur就是叶子结点
            if(parent == null){
                //cur双亲不存在----cur是根节点
                root = cur.right;
            }else{
                //双亲存在
                if(cur == parent.left){
                    parent.left = cur.right;
                }else{
                    parent.right = cur.right;
                }
            }
        }
        else if(cur.right == null){
            //cur只有左孩子
            if(parent == null){
                root = cur.left;
            }else{
                if(cur == parent.left){
                    parent.left = cur.left;
                }else{
                    parent.right = cur.left;
                }
            }
        }
        else{
            //cur左右孩子均存在---不能直接删除
            //在cur子树中找一个替代节点删除
            //找替代节点的方式：
            //1、在其右孩子中找最小的节点---即最左侧的节点
            //2、在其左孩子中找最大的节点---即最右侧的节点
            BSTNode del = cur.right;
            parent = cur;
            while(del.left!=null){
                parent = del;
                del = del.left;
            }
            //替代节点已找到，删除替代节点
            cur.val = del.val;
            if(del == parent.left){
                parent.left = del.right;
            }else{
                parent.right = del.right;
            }
        }
        return true;
    }

    BSTNode prev = null;
    public BSTNode BSTreeToList(){
        if(root == null){
            return null;
        }

        //1、找树中最小的（最左侧的）节点，即双向链表的头结点
        BSTNode head = root;
        while(head.left != null){
            head = head.left;
        }
        //2、修改每个节点的left和right指向
        BSTreeToList(root);
        return head;
    }
    public void BSTreeToList(BSTNode root){
        if(root == null){
            return;
        }
        //转化根节点的左子树
        BSTreeToList(root.left);

        //转化根节点
        root.left = prev;
        if(prev != null){
            prev.right = root;
        }
        //用prev把刚刚遍历的节点保存起来
        prev = root;

        //转化根节点的右子树
        BSTreeToList(root.right);
    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(BSTNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val+" ");
            inOrder(root.right);
        }
    }

    //将二叉搜索树转为双向链表
    public static void TestBSTree(){
        int[] array={5,4,3,2,6,1,0,7,8,9};
        BSTree t = new BSTree();
        for (int e:array) {
            t.put(array[e]);
        }
        BSTNode head = t.BSTreeToList();
        BSTNode cur = head;
        while(cur!=null){
            System.out.print(cur.val+"-->");
            cur = cur.right;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        TestBSTree();
        int[] array={5,4,3,2,6,1,0,7,8,9};
        BSTree t = new BSTree();
        for (int e:array) {
            t.put(array[e]);
        }
        t.inOrder();
        System.out.println();
        System.out.println(t.leftMost());
        System.out.println(t.rightMost());
    }
}
