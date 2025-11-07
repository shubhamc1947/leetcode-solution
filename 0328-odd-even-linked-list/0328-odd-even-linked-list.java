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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode oHead=head;
        ListNode eHead=head.next;
        ListNode tOdd=oHead;
        ListNode tEven=eHead;
        while(tEven!=null && tEven.next!=null){
            tOdd.next=tEven.next;
            tOdd=tOdd.next;
            
            tEven.next=tOdd.next;
            tEven=tEven.next;
        }
        tOdd.next=eHead;
        return head;
    }
}