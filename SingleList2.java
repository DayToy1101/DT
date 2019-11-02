//节点类
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}
//链表
public class SingleList {
    private ListNode head;
    public SingleList(){

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
    //获取单链表的长度
    private int size(){
        int size=0;
        ListNode cur=this.head;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        return size;
    }
    //头插法
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=head;
            this.head=node;
        }
    }
    //尾插法
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
    //找到第index-1号的位置
    private ListNode searchList(int index){
        ListNode cur=this.head;
        for(int i=0;i<index-1;i++){
            cur=cur.next;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        ListNode node=new ListNode(data);
        ListNode cur=this.head;
        if(index<0||index>size()){
            System.out.println("插入位置不合法！");
            return false;
        } else if(index==0){
            addFirst(data);
            return true;
        }else{
            ListNode pre=searchList(index);
            node.next=pre.next;
            pre.next=node;
            return true;
        }
    }
    //查找在单链表当中是否包含关键字key
    public boolean contains(int key) {
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //查找要删除的关键字key节点的前驱
    public ListNode searchPrev(int key){
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
    //删除链表中第一次出现的关键字key
    public void remove(int key){
        if(this.head==null){
            System.out.println("此链表是空链表！");
            return;
        }
        if(this.head.data==key){
            this.head=this.head.next;
            return;
        }
        ListNode pre=searchPrev(key);
        if(pre!=null){
            pre.next=pre.next.next;
        }
    }
    //删除链表中所有出现的关键字key
    public void removeAllKey(int key){
        ListNode pre=this.head;
        ListNode cur=this.head.next;
        while(cur!=null){
            if(cur.data==key){
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
    }
    //反转单链表
    public ListNode reverseList(){
        ListNode pre=null;
        ListNode newHead=null;
        ListNode cur=this.head;
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
    //打印反转后的单链表
    public void display2(ListNode newHead){
        ListNode cur=newHead;
        while(cur!=null){
            System.out.print(cur.data+"  ");
            cur=cur.next;
        }
        System.out.println("\n");
    }
    //返回链表的中间节点
    public ListNode middleNode(){
        ListNode slow=this.head;
        ListNode fast=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //返回单链表倒数第k个节点
    public ListNode findKthToTail(int k){
        if(k<=0){
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
}
