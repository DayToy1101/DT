class Solution{
	public Node copyRandomList(Node head){
		if(head==null){
			return null;
		}
		//1.将新老链表串成一个链表；
		Node cur=head;
		while(cur!=null){
			Node node=new Node(cur.val,cur.next,null);
			Node tmp=cur.next;
			cur.next=node;
			cur=tmp;
		}
		//2.开始解决random指针;
		cur=head;
		while(cur!=null){
			if(cur.random!=null){
				cur.next.random=cur.random.next;
			}else{
				cur.next.random=null;
			}
			cur=cur.next.next;
		}
		//3.开始拆分链表；此时cur表示的是需要拆开的节点。
		cur=head;
		Node newHead=head.next;
		while(cur.next!=null){
			Node tmp=cur.next;
			cur.next=tmp.next;
			cur=tmp;
		}
	}
}