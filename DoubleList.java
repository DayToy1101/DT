
class ListNode{
    public int data;
    public ListNode prev;//前驱
    public ListNode next;//后继
    //new ListNode(10);
    public ListNode(int data){
        this.data=data;
    }
}

public class DoubleList {
    public ListNode head;//代表头节点
    public ListNode last;//代表尾节点

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    //打印链表
    public void display() {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println("\n");
    }

    private ListNode searchList(int index) {
        ListNode cur = this.head;
        while (index - 1 > 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }

    //求链表的长度
    public int size() {
        ListNode cur = this.head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            return false;
        }
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == size()) {
            addLast(data);
            return true;
        }
        /*ListNode node=new ListNode(data);
        ListNode cur=this.head;
        while(cur!=null&&index-1>0){
            cur=cur.next;
            index--;
        }*/
        ListNode node = new ListNode(data);
        ListNode cur = searchList(index);
        if (cur != null) {
            node.next = cur.next;
            node.prev = cur;
            cur.next.prev = node;
            cur.next = node;
            return true;
        } else {
            return false;
        }
    }

    //删除第一次出现关键字为key的节点
    public int remove(int key) {
        int oldData = -1;
        ListNode cur = this.head;
        if (this.head.data == key) {
            oldData = this.head.data;
            this.head = this.head.next;
            this.head.prev = null;
            return oldData;
        }
        while (cur.next != null) {
            if (cur.data == key) {
                oldData = cur.data;
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return oldData;
            }
            cur = cur.next;
        }
        if (cur.data == key) {
            oldData = this.last.data;
            this.last = this.last.prev;
            this.last.next = null;
            return oldData;
        }
        return oldData;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur=this.head;
        while(cur!=null){
            remove(key);
            if(remove(key)==-1){
                return;
            }
            cur=cur.next;
        }
    }
    //清除链表
    public void clear(){
        while(this.head!=null){
            ListNode cur=this.head.next;
            this.head.next=null;
            this.head.prev=null;
            this.head=cur;
        }
        this.last=null;
    }
}









