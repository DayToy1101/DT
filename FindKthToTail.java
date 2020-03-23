/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null){
            return null;
        }
        ListNode cur = head;
        int size = 0;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        if(size<k){
            return null;
        }
        ListNode pre = head;
        for(int i = 0;i<size-k;i++){
            pre=pre.next;
        }
        return pre;
    }
}