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

    public int size(ListNode head){
        ListNode curr=head;
        int n=0;
        while(curr!=null){
            curr=curr.next;
            n++;
        }
        return n;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        int n=size(head);
        if(k%n==0) return head;
        k=k%n;
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<k;i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        ListNode newHead=slow.next;
        slow.next=null;
        fast.next=head;
        head=newHead;
        return head;
    }
}