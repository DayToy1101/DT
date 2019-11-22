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
    private ListNode head;
    private SingleList(){

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
    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
        }else {
            ListNode cur=this.head;
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    //打印单链表
    public void display(){
        ListNode cur=this.head;
        while(cur!=null){
            System.out.println(cur.data);
            cur=cur.next;
        }
    }
    //查找链表中是否含有关键字key
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
    //删除第一次出现的关键字key
    public void remove(int key){
        ListNode cur=this.head;
        if(cur==null){
            System.out.println("链表为空链表！");
            return;
        }
        if(cur.data==key){
            this.head=cur.next;
            return;
        }
        ListNode pre=searchPrev(key);
        if(pre!=null){
            pre.next=cur.next;
        }
    }
	//防止内存泄漏，清空单链表
	public void clear(){
		/*//按顺序一个一个置为空
		while(this.head!=null){
			ListNode cur=this.head.next;
			this.head.next=null;
			this.head=cur;
		}*/
		//直接将头节点置为空
		this.head=null;
	}
    //反转单链表
    public ListNode reverseList() {
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
    //返回单链表倒数第k个节点
    public ListNode findKthToTail(int k){
        if(k<=0){
            System.out.println("位置不合法！");
			return null;
        }
        ListNode cur=this.head;
        ListNode pre=this.head;
        while(k-1>0){
			if(fast.next!=null){
				fast=fast.next;
				k--;
			}else{
				System.out.println("  ");
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
