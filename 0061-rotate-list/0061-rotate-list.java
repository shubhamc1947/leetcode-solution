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
    public int sizeLL(ListNode head){
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            temp=temp.next;
            size++;
        }
        return size;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }

        int size=sizeLL(head);

        if(k%size==0) return head;

        k=k%size;

        ListNode fast=head;
        ListNode slow=head;
        int n=size;
        while(k>0){
            System.out.println(fast.val);
            fast=fast.next;
            k--;
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