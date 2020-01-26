class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}


public class SingleList11 {
    public ListNode head;
    public SingleList11(){

    }
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=this.head;
            this.head=node;
        }
    }
    public void addLast(int data){
        ListNode node=new ListNode(data);
        ListNode cur=this.head;
        if(this.head==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    public ListNode reverseList(){
        ListNode cur=this.head;
        ListNode pre=null;
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
    public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    public void display2(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    public ListNode middleList(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public boolean isPalindrome(){
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
    //以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(int x){
        if(this.head==null||this.head.next==null){
            return this.head;
        }
        ListNode beforestart=null;
        ListNode beforend=null;
        ListNode afterstart=null;
        ListNode afterend=null;
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data<x){
                if(beforestart==null){
                    beforestart=cur;
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
        if(beforestart==null){
            return afterstart;
        }
        if(afterstart!=null){
            afterend.next=null;
        }
        beforend.next=afterstart;
        return beforestart;
    }
    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public ListNode deleteDuplication(){
        ListNode node=new ListNode(-1);
        ListNode tmp=node;
        ListNode cur=this.head;
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

}
