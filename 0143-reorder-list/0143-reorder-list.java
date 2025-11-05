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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        //step 1 find middle

        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        //step2 store second list head and break the list and reverse the second LL

        ListNode head2=slow.next;
        slow.next=null;
        head2=reverseLL(head2);

        // reorder maintaining existing heads

        ListNode temp1=head;
        ListNode temp2=head2;
        while(temp2!=null){
            ListNode next1=temp1.next;
            ListNode next2=temp2.next;
            temp1.next=temp2;
            temp2.next=next1;

            temp1=next1;
            temp2=next2;
        }
        
    }
}