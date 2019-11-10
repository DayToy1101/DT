
//节点类
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
public class MySingleList6 {
    private int data;
    public ListNode head;
    public MySingleList6(){

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
        if(this.head==null){
            this.head=node;
        }else{
            ListNode cur=this.head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    public ListNode reseverList(){
        ListNode cur=this.head;
        ListNode pre = null;
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
    public ListNode middleList(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    private ListNode searchList(int key){
        ListNode cur=this.head;
        ListNode pre;
        while(cur.next!=null){
            if(cur.next.data==key){
                pre=cur;
                return pre;
            }
            cur=cur.next;
        }
        return null;
    }
    public void remove(int key){
        if(this.head==null){
            System.out.println("此链表为空！");
            return;
        }
        if(this.head.data==key){
            this.head=this.head.next;
            return;
        }
        ListNode pre=searchList(key);
        if(pre!=null){
            pre.next=pre.next.next;
        }
    }
    public void removeAllkey(int key){
        ListNode cur=this.head;
        while(cur!=null){
            remove(key);
            cur=cur.next;
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
    public int size(){
        ListNode cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }
    private ListNode searchList2(int index){
        ListNode pre=this.head;
        while(index-1>0){
            pre=pre.next;
            index--;
        }
        return pre;
    }
    public void addIndex(int index,int data){
        ListNode node=new ListNode(data);
        if(index<0||index>size()){
            System.out.println("插入位置不合法！");
            return;
        }
        if(index==0){
            node.next=this.head;
            this.head=node;
            return;
        }
        ListNode pre=searchList2(index);
        if(pre!=null){
            node.next=pre.next;
            pre.next=node;
        }
    }
    public ListNode findKthToTail(int k){
        if(k<=0){
            System.out.println("输入位置不合法！");
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(k-1>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                System.out.println(" ");
                return null;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    public boolean contains(int key){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
}
