
//节点类
class ListNode{
    public int data;
    public ListNode next;


    public ListNode(int data){
        this.data=data;
        this.next=null;
    }
}

public class MySingleList {
    public ListNode head;
    public MySingleList(){

    }
    //头插法
    //  1、判断是不是第一次插入
    //  2、进行插入操作
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
        ListNode cur=this.head;
        if(cur==null){
            cur.next=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    //找到index下标的前一个位置
    private ListNode searchIndex(int index) {
        ListNode cur = this.head;
        for(int i=0;i<index-1;i++){
            cur=cur.next;
            //cur -> index-1
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data) {
        ListNode node=new ListNode(data);
        if(index<0||index>size()){
            System.out.println("index不合法!");
            return false;
        } else if(index==0){
            addFirst(data);
            return true;
        }else {
            ListNode cur=searchIndex(index);
            node.next=cur.next;
            cur.next=node;
            return true;
        }

    }

    //查找是否包含关键字key是否在单链表当中
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
        while(cur!=null){
            cur=cur.next;
            if(cur.data==key){
                pre=cur.next;
                return pre;
            }
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        //链表为空时直接返回空
        if(this.head==null){
            System.out.println("链表是空链表");
            return;
        }
        //1.判断删除的是否为头节点
        if(this.head.data==key){
            this.head=this.head.next;
            return;
        }
        //2.找到关键字key的前驱
        ListNode pre=searchPrev(key);
        if(pre!=null){
            pre.next=pre.next.next;
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode pre=this.head;
        ListNode cur=this.head.next;
        while(cur!=null){
            if(pre.next.data==key){
                pre.next=cur.next;
                cur=cur.next;
            }else {
                pre=cur;
                cur=cur.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }
    //得到单链表的长度
    public int size(){
        ListNode cur=this.head;
        int size=0;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        return size;
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
    //清空单链表
    public void clear(){

    }
    //反转单链表
    public ListNode reverseList() {
        ListNode prev =null;
        ListNode newHead=null;
        ListNode cur=this.head;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null) {
                newHead = cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
            //curNext=cur.next;
        }
        return newHead;
    }
    //返回链表的中间节点
    public ListNode middleNode(){
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null && fast.next!=null){
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
            if(fast.next!=null) {
                fast = fast.next;
                k--;
            }else{
                System.out.println("");
                return null;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
    }
}
