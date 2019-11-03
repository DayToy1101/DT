public class Test4 {
    //创建两个相交的链表
    public static void createNode(ListNode headA,ListNode headB){
        headA.next.next=headB.next.next.next.next;
    }
    //找到两个链表相交的节点
    public static ListNode  getIntersectionNode(ListNode headA,ListNode headB){
        if(headA == null || headB == null) {
            return null;
        }
        //永远指向最长的单链表
        ListNode pL = headA;
        //永远指向最短的单链表
        ListNode pS = headB;
        //分别求长度
        int lenA = 0;
        while(pL!=null){
            lenA++;
            pL=pL.next;
        }
        int lenB = 0;
        while(pS!=null){
            lenB++;
            pS=pS.next;
        }
        //求长度的差值
        int len = lenA-lenB;
        //如果是负数-》pL = headB;  pS = headA
        if(len < 0){
            pL=headB;
            pS=headA;
            len *= -1;
        }else{
            pL=headA;
            pS=headB;
        }

        //只需要让pL走len步就好了
        while(len>0){
            pL=pL.next;
            len--;
        }
        //走完len步之后  两个同时开始走
        //一直走 走到next值相同时 就是交点
        while(pL!=pS&&pL!=null) {
            pS=pS.next;
            pL=pL.next;
        }
        if(pL==pS&&pS!=null){
            return pL;
        }
       /* if(pL==null||pL.next==null){
            return null;
        }*/
        return null;
    }

    //将两个有序链表合并为一个新的有序链表
    public static ListNode mergeTwoLists(ListNode headA,ListNode headB){
        ListNode node=new ListNode(-1);
        ListNode tmp=node;
        while(headA!=null&&headB!=null){
            if(headA.data<headB.data){
                tmp.next=headA;
                headA=headA.next;
                tmp=tmp.next;
            }else{
                tmp.next=headB;
                headB=headB.next;
                tmp=tmp.next;
            }
        }
        if(headA!=null){
            tmp.next=headA;
        }
        if(headB!=null){
            tmp.next=headB;
        }
        return node.next;
    }

    public static void main(String[] args) {
        //两个链表相交是Y型的
        SingleList list1=new SingleList();
        list1.addFirst(9);
        list1.addFirst(6);
        list1.addFirst(4);
        list1.addFirst(2);
        SingleList list2=new SingleList();
        list2.addFirst(12);
        list2.addFirst(11);
        list2.addFirst(10);
        list2.addFirst(8);
        list2.addFirst(7);
        ListNode node=Test4.mergeTwoLists(list1.head,list2.head);
        list1.display(node);
        //Test4.createNode(list1.head,list2.head);
       /* ListNode node=Test4.getIntersectionNode(list1.head,list2.head);
        System.out.println(node.data);*/
        /*SingleList list=new SingleList();
        list.addFirst(1);//头插法
        list.addFirst(2);
        list.addFirst(2);
        list.addFirst(1);*/
        /* list.addFirst(1);
        list.addFirst(3);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);*/
        //打印链表
        //list.display();
        //以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
        //list.display(list.partition(5));
        //删除链表中的重复节点
        //list.display(list.deleteDuplication());
        //判断链表是否为回文结构
        //System.out.println(list.chkPalindrome());
        //list.createLoop();//建立一个带环的链表
        //判断链表中是否有环
        //System.out.println(list.hasCycle());
        //寻找单链表中环的入口点
        //System.out.println(list.detectCycle());
        //求环的长度
        //System.out.println(list.listLength());

    }
}
