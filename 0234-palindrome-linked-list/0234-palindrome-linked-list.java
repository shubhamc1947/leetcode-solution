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
    public ListNode findMidNode(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverseLL(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public boolean checkPalindrome(ListNode h1,ListNode h2){
        ListNode temp1=h1;
        ListNode temp2=h2;
        while(temp1!=null && temp2!=null){
            if(temp1.val==temp2.val){
                temp1=temp1.next;
                temp2=temp2.next;
            }else{
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        ListNode mid=findMidNode(head);
        ListNode head2=mid.next;
        mid.next=null; //broke chain
        head2=reverseLL(head2);

        return checkPalindrome(head, head2);
    }
}