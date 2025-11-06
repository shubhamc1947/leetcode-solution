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
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if(h1==null || h2==null){
            return h1==null?h2:h1;
        }
        ListNode temp1=h1;
        ListNode temp2=h2;
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(temp1!=null|| temp2!=null){
            int val1=temp1==null?Integer.MAX_VALUE:temp1.val;
            int val2=temp2==null?Integer.MAX_VALUE:temp2.val;
            if(val1<val2){
                curr.next=temp1;
                temp1=temp1.next;
            }else{
                curr.next=temp2;
                temp2=temp2.next;
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}