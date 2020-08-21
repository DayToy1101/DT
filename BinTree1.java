import java.util.Arrays;
import java.util.Scanner;

/*
import java.util.*;

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
    private int index = 0;//。仅在创建二叉树时使用
    public BinTree(int[] array,int invalid){
        root = createBinTree(array,invalid);
    }
    BTNode createBinTree(int[] array,int invalid){
        BTNode newRoot = null;
        if(index<array.length&&array[index]!=invalid){
            newRoot = new BTNode(array[index]);

            ++index;
            newRoot.left=createBinTree(array,invalid);
            ++index;
            newRoot.right=createBinTree(array,invalid);
        }
        return newRoot;
    }
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
    //获取二叉树中节点的个数
    public int getNodeCount(BTNode root){
        if(root!=null){
            return getNodeCount(root.left)+getNodeCount(root.right)+1;
        }
        return 0;
    }
    //获取叶子节点的个数
    public int getLeafCount(BTNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        return getLeafCount(root.left)+getLeafCount(root.right);
    }
    //获取第K层节点的个数
    public int getKLevelNodeCount(BTNode root,int k){
        if(root==null||k<1){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1)+getKLevelNodeCount(root.right,k-1);
    }
    //求二叉树的高度
    public int getHeight(BTNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight>=rightHeight?leftHeight+1:rightHeight+1;
    }
    //判断val在树中对应的节点，找到返回节点，没有返回null
    public BTNode find(BTNode root,int val){
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        BTNode retNode = null;
        if((retNode = find(root.left,val))!=null||(retNode = find(root.right,val))!=null){
            return retNode;
        }
        return null;
    }
    public boolean isBalanceTree(BTNode root){
        if(root==null){
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight-rightHeight)>=1){
            return false;
        }
        return isBalanceTree(root.left)&&isBalanceTree(root.right);
    }
    //层序遍历（广度优先遍历）
    public static void sequenceNode(BTNode root){
        if(root==null){
            return;
        }
        Queue<BTNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            BTNode cur = q.poll();
            System.out.print(cur);
            if(cur.left!=null){
                q.offer(cur.left);
            }
            if(cur.right!=null){
                q.offer(cur.right);
            }
        }
    }
    //前序非递归遍历--》借助栈（后进先出）
    public static void preOrserNor(BTNode root){
        if(root==null){
            return;
        }
        Stack<BTNode> s = new Stack<>();
        s.push(root);
        while(!s.empty()){
            BTNode cur = s.peek();//取栈顶元素
            System.out.print(cur.val+" ");
            s.pop();//删除栈顶元素
            //如果cur存在子树，先将cur的右子树入栈
            if(cur.right!=null){
                s.push(cur.right);
            }
            if(cur.left!=null){
                s.push(cur.left);
            }
        }
        System.out.println();
    }
    public static void preOrserNor2(BTNode root) {
        if (root == null) {
            return;
        }
        Stack<BTNode> s = new Stack<>();
        s.push(root);
        while (!s.empty()) {
            BTNode cur = s.peek();//取栈顶元素
            s.pop();
            //顺着cur的左子树一直往下遍历，如果有右子树，将右子树保存
            while (cur != null) {
                System.out.print(cur.val + " ");
                if (cur.right != null) {
                    s.push(cur.right);
                }
                cur = cur.left;
            }
        }
        System.out.println();
    }
    //中序非递归遍历
    public void inorderNor(BTNode root){
        if(root == null){
            return;
        }
        //1、找以root为根的二叉树最左侧的节点，并保存所经路径中所有的节点--->栈
        BTNode cur = root;
        Stack<BTNode> s = new Stack<>();
        while(cur!=null||!s.empty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            //cur为空，认为这棵树已经遍历
            //可以遍历cur的根节点，cur的根节点此时在栈顶
            cur = s.peek();
            System.out.println(cur.val+" ");
            s.pop();
            //此时已经遍历完以cur为根的左子树，在遍历cur的右子树
            cur=cur.right;
        }
        System.out.println();
    }
    //后序非递归遍历
    public void postOrderNor(BTNode root){
        if(root==null){
            return;
        }
        BTNode cur = root;
        BTNode prev = null;//标记遍历过的节点
        Stack<BTNode> s = new Stack<>();
        while(cur!=null||!s.empty()){
            //1、找以cur为根的二叉树的最左侧的节点，并保存所经路径中的所有节点
            while(cur!=null){
                s.push(cur);
                cur=cur.left;
            }

            //2、获取cur的子树的根
            BTNode top = s.peek();

            //3、遍历top的右子树
            //top的右子树为空--》遍历根节点
            //top的右子树已经遍历完成--》也可以直接遍历根节点
            if(top.right==null||top.right==prev){
                System.out.println(top.val+" ");
                prev = top;
                s.pop();
            }else{
                //top的右子树不为空
                cur = top.right;
            }
        }
    }
    public boolean isCompleteTree(BTNode root){
        //空树也是完全二叉树
        if(root==null){
            return true;
        }
        //树非空
        //1、按照层序遍历的方式找第一个不饱和的节点（叶子，只有你一个孩子的节点）
        Queue<BTNode> q= new LinkedList<>();
        q.offer(root);
        boolean isLeafOrLeft = false;
        while(!q.isEmpty()){
            BTNode cur = q.poll();
            if(isLeafOrLeft){
                //2、从第一个不饱和节点之后，所有节点不能有孩子节点
                if(cur.left!=null||cur.right!=null){
                    return false;
                }
            }else{
                if(null!=cur.left&&cur.right!=null){
                    q.offer(root.left);
                    q.offer(root.right);
                }
                //只有左孩子
                else if(cur.left!=null){
                    q.offer(root.left);
                    isLeafOrLeft=true;
                }
                //只有右孩子
                else if(cur.right!=null){
                    return false;
                }
                //cur是叶子结点
                else{
                    isLeafOrLeft=true;
                }
            }
        }
        return true;
    }
    public static void main1(String[] args) {
        int[] array = {1,2,3,-1,5,-1,4};
        BinTree bt = new BinTree(array,-1);
        BTNode root = bt.root;
        bt.rightSideView(root);
//        String s= "dddd";
//        s.
    }
    public List<Integer> rightSideView(BTNode root) {
        List<Integer> list = new LinkedList<>();
        if(root==null){
            return list;
        }
        //Queue<Integer> q = new LinkedList<>();
        list.add(root.val);
        BTNode cur = root.right;
        while(cur!=null){
            list.add(cur.val);
            cur=cur.right;
        }
        if(cur==null){
            list.add((root.left).val);
        }
        return list;
    }
    public static void main(String[] args){
        */
/*Scanner sc = new Scanner(System.in);
        //while(sc.hasNextInt()){
            int n = sc.nextInt();
            if(n!=0){
                int ret = maxSum(n);
                System.out.println(ret);
            }
        //}*//*

//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        System.out.println(getMaxNum(str));
        String str = "()()()[]{}";
        System.out.println(chkParenthesis(str,10));
    }
    public static StringBuffer getMaxNum(String str1)
    {
        int maxLength=0;
        StringBuffer maxNumBuffer=null;
        int nowLength=0;
        StringBuffer nowNumBuffer=null;
        for(int i=0;i<str1.length();i++)
        {
            //判断该字符是不是数字
            if(str1.charAt(i)>=48 && str1.charAt(i)<=57)
            {
                //处理第一个数字字符的时候，用append(c)会报空指针异常
                if(nowLength==0)
                {
                    nowNumBuffer=new StringBuffer(String.valueOf(str1.charAt(i)));
                    nowLength++;
                }
                else
                {
                    nowNumBuffer.append(str1.charAt(i));
                    nowLength++;
                    if(nowLength>=maxLength)
                    {
                        maxLength=nowLength;
                        maxNumBuffer=nowNumBuffer;
                    }
                }
            }else
            {
                //用于连续数字之后非数字，清楚当前的nowNumBuffer
                nowLength=0;
                nowNumBuffer=null;
            }
        }
        return maxNumBuffer;
    }
    public static String maxStr(String str){
        String[] rs = str.split(" ");
        String ret = rs[0];
        for(int i = 1;i<rs.length;i++){
            if(rs[i].length()>ret.length()){
                ret = rs[i];
            }
        }
        return ret;
    }
    public static boolean chkParenthesis(String A, int n) {
        Stack<String> a = new Stack<>();
        Stack<String> b = new Stack<>();
        Stack<String> c = new Stack<>();
        //char[] a = A.toCharArray();
        for(int i = 0;i<n;i++){
            if(A.charAt(i)=='('){
                a.push(String.valueOf(A.charAt(i)));
            }else if(A.charAt(i)==')'){
                a.pop();
            }else if(A.charAt(i)=='{'){
                b.push(String.valueOf(A.charAt(i)));
            }else if(A.charAt(i)=='}'){
                b.pop();
            }else if(A.charAt(i)=='['){
                c.push(String.valueOf(A.charAt(i)));
            }else if(A.charAt(i)==']'){
                c.pop();
            }
            else{
                return false;
            }
        }
        if(a.empty()&&b.empty()&&c.empty()){
            return true;
        }
        return false;

    }
    public static int maxSum(int n){
        int count = 0;
        int x = 0;
        while(n>=2){
            count += n/3;
            x = n/3;
            n=n-(3*x)+x;
            if(n==2){
                count++;
            }
        }
        return count;
    }
}
*/
public class BinTree{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int num = arr[n/2];
        int count = 0;
        for(int j = 0;j<n;j++){
            if(arr[j]==num){
                count++;
            }
        }
        if(count>=(n/2)){
            System.out.println(num);
        }
    }
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i = 0;i<4;i++){
            arr[i]=sc.nextInt();
        }

    }*/

    /*static  int[] record ;
    static  int n ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        record =new int[n];
        for (int i = 0; i < n; i++) {
            record[i]=scanner.nextInt();
        }
        int count = fun(0, 40);
        System.out.println(count);
    }
    static int  fun(int i,int sum){
        //结束
        if (i==n) return 0;
        //刚好够，注意，这里还可以不填充继续递归
        if (record[i]==sum) return 1+fun(i+1,sum);
        else if (sum>record[i]) return fun(i+1,sum-record[i])+fun(i+1,sum);
        //sum<record[i]
        return fun(i+1,sum);
    }*/
}
