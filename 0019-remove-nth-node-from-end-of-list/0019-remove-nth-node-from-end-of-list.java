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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        if(len==1) return null;
        if(len-n==0) return head.next;
        temp=head;
        ListNode prev=null;
        //from front=> len-n 5-2
        for(int i=1;i<=len-n;i++){
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;
        return head;
    }
}