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
    public ListNode mergeTwoLists(ListNode l, ListNode r) {
        ListNode ans=new ListNode(-1);
        ListNode temp=ans;
        while(l!=null && r!=null){
            if(l.val<r.val){
                temp.next=l;
                temp=temp.next;
                l=l.next;
            }else{
                temp.next=r;
                temp=temp.next;
                r=r.next;
            }
        }
        while(l!=null){
            temp.next=l;
            temp=temp.next;
            l=l.next;
        }
        while(r!=null){
            temp.next=r;
            temp=temp.next;
            r=r.next;
        }
        return ans.next;
    }
}