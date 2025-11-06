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
        if(head==null) return 0;
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;

        int size=sizeLL(head);

        int idx=size-n;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode temp=dummy;

        for(int i=1;i<=idx;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return dummy.next;
    }
}