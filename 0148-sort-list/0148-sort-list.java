/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        //base Case 
        if(head==null||head.next==null)   {
            return head;
        }
        ListNode mid=middleNode(head);
        ListNode right=mid.next;
        mid.next=null;
        ListNode LHS=sortList(head);
        ListNode RHS=sortList(right);
        ListNode newhead=merge(LHS,RHS);
        return newhead;
        
    }
    public ListNode merge(ListNode ls1,ListNode ls2){
        ListNode newHead=new ListNode(-101);
        ListNode tmp1=ls1,tmp2=ls2,tmp=newHead;
        while(tmp1!=null&&tmp2!=null){
            if(tmp1.val<tmp2.val){
                tmp.next=tmp1;
                tmp1=tmp1.next;
            }else{
                tmp.next=tmp2;
                tmp2=tmp2.next;
            }
            tmp=tmp.next;
        }
        if(tmp1!=null){
            tmp.next=tmp1;
        }
        if(tmp2!=null){
            tmp.next=tmp2;
        }
        return newHead.next;
    }
    public ListNode middleNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        return prev;
    }
}