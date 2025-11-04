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
        if(head==null) return null;
        ListNode odd=new ListNode(-1);
        ListNode even=new ListNode(-1);

        ListNode ans=odd;
        ListNode ans2=even;
        ListNode curr=head;
        int count=1;
        while(curr!=null){
            ListNode newNode=new ListNode(curr.val);
            if(count%2==0){
                // even node
                even.next=newNode;
                even=even.next;
            }else{
                // odd node
                odd.next=newNode;
                odd=odd.next;
            }
            curr=curr.next;
            count++;
        }
        odd.next=ans2.next;
        return ans.next;
    }
}