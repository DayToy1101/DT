
//节点类
class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}

public class MySingleList1 {
    public ListNode head;
    public MySingleList1(){

    }
    //打印单链表
    public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println("\n");
    }
    //给定单链表头指针打印单链表
    public void display(ListNode newHead){
        ListNode cur=newHead;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println("\n");
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
    //获取单链表的长度
    public int size(){
        ListNode cur=this.head;
        int size=0;
        while(cur!=null){
            cur=cur.next;
            size++;
        }
        return size;
    }
    //查找index-1位置的节点
    private ListNode searchList(int index){
        ListNode cur=this.head;
        for(int i=0; i<index-1;i++){
            cur=cur.next;
        }
        return cur;
    }
    //在任意index位置插入一个新节点，链表开始节点的下标为0
    public boolean addIndex(int index,int data){
        ListNode node=new ListNode(data);
        if(index<0||index>size()){
            System.out.println("插入位置不合法！");
            return false;
        }else if(index==0){
            addFirst(data);
            return true;
        }
        ListNode pre=searchList(index);
        node.next=pre.next;
        pre.next=node;
        return true;
    }
    //查找单链表中是否含有关键字key
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
    //查找关键字key的前驱
    private ListNode searchPrev(int key){
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
    //删除链表中第一次出现关键字key的节点
    public void remove(int key){
        if(this.head==null){
            System.out.println("此链表为空链表！");
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
    //删除所有关键字为key的节点
    public void removeAll(int key){
        ListNode pre=this.head;
        ListNode cur=this.head.next;
        if(this.head.data==key){
            this.head=this.head.next;
        }
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
    //返回但单链表的中间节点
    public ListNode middleList(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //返回单链表的倒数第k个节点
    public ListNode findKthToTail(int k){
        if(k<0||k>size()){
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(k-1>0){
            if(fast!=null&&fast.next!=null){
                fast=fast.next;
                k--;
            }else{
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
