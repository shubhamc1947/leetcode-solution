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
        ArrayList<Integer> even=new ArrayList<>();
        ArrayList<Integer> odd=new ArrayList<>();
        ListNode temp=head;
        int idx=0;
        while(temp!=null){
            if(idx%2==0){
                even.add(temp.val);
            }else{
                odd.add(temp.val);
            }
            temp=temp.next;
            idx++;
        }

        ListNode newHead=new ListNode(-1);
        ListNode currTemp=newHead;
       
        for(int i=0;i<even.size();i++){
            ListNode curr=new ListNode(even.get(i));
            currTemp.next=curr;
            currTemp=curr;
        }
         for(int i=0;i<odd.size();i++){
            ListNode curr=new ListNode(odd.get(i));
            currTemp.next=curr;
            currTemp=curr;
        }
        return newHead.next;


        
    }
}