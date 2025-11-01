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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        int sum=0;
        int carray=0;
        ListNode ans=new ListNode(-1);
        ListNode temp=ans;
        while(l1!=null || l2!=null || carray==1){
            sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            sum+=carray;
            System.out.println(sum);
            int curr=sum%10;
            carray=sum/10;

            ListNode currN=new ListNode(curr);
            temp.next=currN;
            temp=currN;
        }
        return ans.next;
    }
}