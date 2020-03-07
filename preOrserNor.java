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