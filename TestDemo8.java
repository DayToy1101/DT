# DT
Java之征，我来啦！！！
public class TestDemo8 {
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
    //创建两个相交的链表
    public static void createNode(ListNode headA,ListNode headB){
        headA.next.next=headB.next.next.next.next;
    }
    //找到两个链表相交的节点
    public static ListNode  getIntersectionNode(ListNode headA,ListNode headB){
        if(headA==null||headB==null){
            return null;
        }
        ListNode pL=headA;
        ListNode pS=headB;
        int lenA=0;
        while(pL!=null){
            lenA++;
            pL=pL.next;
        }
        int lenB=0;
        while(pS!=null){
            lenB++;
            pS=pS.next;
        }
        int len=lenA-lenB;
        if(len<0){
            pL=headB;
            pS=headA;
            len *= -1;
        }else{
            pL=headA;
            pS=headB;
        }
        while(len>0){
            pL=pL.next;
            len--;
        }
        while(pL!=pS&&pL!=null){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS&&pL!=null){
            return pL;
        }
        return null;
    }
    public static void main(String[] args) {
        //两个链表相交是Y型的
        SingleList8 list1 = new SingleList8();
        list1.addFirst(9);
        list1.addFirst(6);
        list1.addFirst(4);
        list1.addFirst(2);
        SingleList8 list2 = new SingleList8();
        list2.addFirst(12);
        list2.addFirst(11);
        list2.addFirst(10);
        list2.addFirst(8);
        list2.addFirst(7);
        ListNode node = TestDemo8.mergeTwoLists(list1.head, list2.head);
        list1.display(node);
        TestDemo8.createNode(list1.head,list2.head);
        ListNode node1=TestDemo8.getIntersectionNode(list1.head,list2.head);
        System.out.println(node1.data);
    }
}


