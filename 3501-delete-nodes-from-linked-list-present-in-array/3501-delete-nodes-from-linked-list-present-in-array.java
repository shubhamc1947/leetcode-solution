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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums) hs.add(i);

        ListNode curr=head;
        ListNode prev=new ListNode(11);
        prev.next=head;
        ListNode newHead=prev;
        while(curr!=null){
            if(hs.contains(curr.val)){
                prev.next=curr.next;
                curr=prev.next;
            }else{
                prev=prev.next;
                curr=curr.next;
            }
        }
        return newHead.next;
    }
}
