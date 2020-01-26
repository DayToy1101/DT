//节点类
class ListNode{
    public int data;
    public ListNode next;
    public ListNode prev;
    public ListNode(int data){
        this.data=data;
    }
}

public class DoubleList2 {
    public ListNode head;//头节点
    public ListNode last;//尾节点
    public DoubleList2(){

    }
    public void addFirst(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else{
            node.next=this.head;
            this.head.prev=node;
            this.head=node;
        }
    }
    public void addLast(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        }
        else{
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }
    }
    public void display(){
        if(this.head==null){
            System.out.println("此来链表为空！");
            return;
        }
        ListNode cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    private int size(){
        ListNode cur=this.head;
        int size=0;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        return size;
    }
    private ListNode searchList(int index){
        ListNode cur=this.head;
        while(index-1>0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data){
        if(index<0||index>size()){
            return false;
        }
        if(index==0){
            addFirst(data);
            return true;
        }
        if(index==size()){
            addLast(data);
            return true;
        }
        ListNode node=new ListNode(data);
        ListNode cur=searchList(index);
        if(cur!=null){
            node.next=cur.next;
            node.prev=cur;
            cur.next.prev=node;
            cur.next=node;
            return true;
        }else{
            return false;
        }
    }
    //删除第一次出现关键字为key的节点
    public int remove(int key){
        int oldData=-1;
        ListNode cur=this.head;
        if(this.head.data==key){
            oldData=this.head.data;
            this.head=this.head.next;
            this.head.prev=null;
            return oldData;
        }
        while(cur.next!=null){
            if(cur.data==key){
                oldData=cur.data;
                cur.prev.next=cur.next;
                cur.next.prev=cur.prev;
                return oldData;
            }
            cur=cur.next;
        }
        if(cur.data==key){
            oldData=this.last.data;
            this.last=this.last.prev;
            this.last.next=null;
            return oldData;
        }
        return oldData;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode cur=this.head;
        while(cur!=null){
            remove(key);
            if(remove(key)==-1){
                return;
            }
            cur=cur.next;
        }
    }
}
