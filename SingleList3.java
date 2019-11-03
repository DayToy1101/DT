

//节点类
class ListNode{
    public int data;
    public ListNode next;


    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}


public class SingleList {
    public ListNode head;
    public SingleList() {

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
    //以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(int x) {
        if(this.head==null||this.head.next==null){
            return this.head;
        }
        ListNode cur = this.head;
        //存放小于x的节点
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        //存放大于x的节点
        ListNode afterStart = null;
        ListNode afterEnd = null;
        while (cur != null) {
            //cur.data < x
            if(cur.data < x) {
                //第一次插入
                if(beforeStart==null) {
                    beforeStart=cur;
                    beforeEnd=cur;
                }else {
                    beforeEnd.next=cur;
                    beforeEnd=beforeEnd.next;
                }
            }else {
                //第一次插入
                if(afterStart == null) {
                    afterStart=cur;
                    afterEnd=cur;
                }else {
                    afterEnd.next=cur;
                    afterEnd=afterEnd.next;
                }
            }
            cur=cur.next;
        }
        if(beforeEnd==null){
            return afterStart;
        }
        if(afterStart!=null){
            afterEnd.next=null;
        }
        beforeEnd.next=afterStart;
        return beforeStart;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public ListNode deleteDuplication() {
        ListNode node = new ListNode(-1);
        ListNode cur = this.head;
        ListNode tmp = node;
        while (cur != null) {
            if(cur.next != null && cur.data == cur.next.data) {
                //1、使用循环查找并删除重复的节点
                //2、退出循环 cur要多走一步
                while(cur.next!=null&&cur.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }else {
                //当前节点 不等于下一个节点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next=null;
        return node.next;
    }
    //链表的回文结构
    public boolean chkPalindrome() {
        //链表为空
        if(this.head==null){
            return false;
        }
        //只有一个节点
        if(this.head.next==null){
            return true;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        //寻找中间节点
        while (fast != null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //从中间节点开始进行反转
        ListNode p = slow.next;
        while (p != null) {
            ListNode pNext = p.next;
            //开始反转
            p.next=slow;
            slow=p;
            p=pNext;
        }
        //slow往前    head 往后  .data不一样 返回false
        //直到相遇（对于奇数个节点来说）
        while(this.head!=slow){
            if(this.head.data==slow.data){
                this.head=this.head.next;
                slow=slow.next;
                //对于偶数个节点来说
                if(this.head.next==slow){
                    return true;
                }
            }
            if(this.head.data!=slow.data){
                return false;
            }
        }
        return true;
    }
    //建立一个带环的单链表
    public void createLoop(){
        ListNode cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next;
    }
    //给定一个链表，判断链表中是否有环
    public boolean hasCycle(){
        if(this.head==null){
            return false;
        }
        if(this.head.next==null){
            return false;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    //寻找单链表中环的入口点
    public ListNode detectCycle(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                slow=this.head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    //求环的长度
    public int listLength(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        int count=1;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                slow=slow.next;
                while(slow!=fast){
                    slow=slow.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }
}
