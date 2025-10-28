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
    public ListNode getMid(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;// we need first list last node
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverseLL(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        // 1=> find mid
        ListNode midNode=getMid(head);
        ListNode rightHead=midNode.next;
        midNode.next=null;
        //2=> reverse 2nd helf
        rightHead=reverseLL(rightHead);
        ListNode leftHead=head;

        //3=> check
        while(leftHead!=null&&rightHead !=null){
            if(leftHead.val!=rightHead.val){
                return false;
            }
            leftHead=leftHead.next;
            rightHead=rightHead.next;
        }
        return true;
    }
}
