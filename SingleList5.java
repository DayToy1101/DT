
//节点类
class ListNode{
    public int data;
    public ListNode next;


    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}


public class SingleList4 {
    public ListNode head;
    public SingleList4() {

    }
    //打印单链表
    public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+"  ");
            cur=cur.next;
        }
        System.out.println("\n");
    }
    //头插法
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
        }else {
            node.next=this.head;
            this.head=node;
        }
    }
    //打印单链表
    public void display(ListNode newHead){
        ListNode cur=newHead;
        while(cur!=null){
            System.out.print(cur.data+"  ");
            cur=cur.next;
        }
        System.out.println("\n");
    }
    //反转单链表
    public ListNode reverseList(){
        ListNode pre=null;
        ListNode cur=this.head;
        ListNode newHead=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        return newHead;
    }

  /*  //以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(int x){
        ListNode beforestart=null;
        ListNode beforeend=null;
        ListNode afterstart=null;
        ListNode afterend=null;
        ListNode cur=this.head;
        if(this.head==null||this.head.next==null) {
            return this.head;
        }
        while(cur!=null) {
            if (cur.data < x) {
                if (beforestart == null) {
                    beforestart = cur;
                    beforeend = cur;
                } else {
                    beforeend.next = cur;
                    beforeend = beforeend.next;
                }
            } else {
                if (afterstart == null) {
                    afterstart = cur;
                    afterend = cur;
                } else {
                    afterend.next = cur;
                    afterend = afterend.next;
                }
            }
            cur = cur.next;
        }
        if()
        beforeend.next=afterstart;
        if(afterstart!=null) {
            beforeend.next=afterstart;
        }


    }*/
}
