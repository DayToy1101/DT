//节点类
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
//建立链表
public class SingleList7 {
    public ListNode head;
    public SingleList7(){

    }
    //头插法
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=this.head;
            this.head=node;
        }
    }
    public void display(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    public void display1(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(int x){
        if(this.head==null||this.head.next==null){
            return this.head;
        }
        ListNode cur=this.head;
        ListNode beforstart=null;
        ListNode beforend=null;
        ListNode afterstart=null;
        ListNode afterend=null;
        while(cur!=null){
            if(cur.data<x){
                if(beforstart==null){
                    beforstart=cur;
                    beforend=cur;
                }else{
                    beforend.next=cur;
                    beforend=beforend.next;
                }
            }else{
                if(afterstart==null){
                    afterstart=cur;
                    afterend=cur;
                }else{
                    afterend.next=cur;
                    afterend=afterend.next;
                }
            }
            cur=cur.next;
        }
        if(beforend==null){
            return afterstart;
        }
        if(afterstart!=null){
            afterend.next=null;
        }
        beforend.next=afterstart;
        return beforstart;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public ListNode deleteDuplication(){
        ListNode cur=this.head;
        ListNode node=new ListNode(-1);
        ListNode tmp=node;
        while(cur!=null){
            if(cur.next!=null&&cur.data==cur.next.data){
                while(cur.next!=null&&cur.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }else{
                tmp.next=cur;
                cur=cur.next;
                tmp=tmp.next;
            }
        }
        tmp.next=null;
        return node.next;
    }
    //链表的回文结构
    public boolean chkPalindrome(){
        if(this.head==null){
            return false;
        }
        if(this.head.next==null){
            return true;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode p=slow.next;
        while(p!=null){
            ListNode pNext=p.next;
            p.next=slow;
            slow=p;
            p=pNext;
        }
        while(this.head!=slow){
            if(this.head.data==slow.data){
                this.head=this.head.next;
                slow=slow.next;
                if(this.head.next==slow){
                    return true;
                }
            }else{
                return false;
            }
        }
        return true;
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
            if(fast==slow){
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
            if(fast==slow){
                slow=this.head;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
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
            if(fast==slow){
                slow=slow.next;
                while(slow!=fast){
                    count++;
                    slow=slow.next;
                }
                return count;
            }
        }
        return 0;
    }
    //建立一个带环的单链表
    public void createLoop(){
        ListNode cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next;
    }
}
