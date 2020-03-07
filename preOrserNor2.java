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