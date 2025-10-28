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
    public ListNode addTwoNumbers(ListNode l, ListNode r) {
        ListNode ans=new ListNode(-1);
        ListNode temp=ans;
        int sum=0,carry=0;
        while(l!=null || r!=null || carry==1){
            sum=0;
            if(l!=null){
                sum+=l.val;
                l=l.next;
            }
            if(r!=null){
                sum+=r.val;
                r=r.next;
            }
            sum+=carry;
            carry=sum/10;
            ListNode newNode=new ListNode(sum%10);
            temp.next=newNode;
            temp=temp.next;
        }
        return ans.next;
    }
}