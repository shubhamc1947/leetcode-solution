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
    //crating custom class for finding size and last Node 
    class Utility{
        int size;
        ListNode tail;
        Utility(int size, ListNode tail){
            this.size=size;
            this.tail=tail;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)return head;
        //finding Tail and size of head
        Utility tempSizeTail=sizetail(head);
        int size=tempSizeTail.size;
        ListNode tail=tempSizeTail.tail;

        k%=size;
        if(k==0)return head;        

        ListNode curr=head;

        for(int i=1;i<size-k;i++){
            curr=curr.next;
        }

        ListNode next=curr.next;
        curr.next=null;
        tail.next=head;
        return next;  
        
    }
    public Utility sizetail(ListNode head){
        ListNode tail=head;
        int size=1;
        while(tail.next!=null){
            tail=tail.next;
            size++;
        }
        return new Utility(size, tail);
    }
}