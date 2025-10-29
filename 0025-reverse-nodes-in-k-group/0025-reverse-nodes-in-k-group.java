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
    public ListNode findKthNode(ListNode temp,int k){
        ListNode curr=temp;
        while(curr!=null && k>1){
            curr=curr.next;
            k--;
        }
        return curr;
    }
    public ListNode reverseLL(ListNode temp){
        ListNode curr=temp;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevNode=null;
        while(temp!=null){
            //find kth Node
            ListNode kthNode=findKthNode(temp,k);
            if(kthNode==null){
                prevNode.next=temp;
                break;
            }
            //preserve next node and break current chain
            ListNode nextNode=kthNode.next;
            //break current chain from temp to kthNode
            kthNode.next=null;
            //reverse from temp to kthNode
            ListNode newHead=reverseLL(temp);
            if(temp==head){//first group
                head=newHead;
            }else{
                prevNode.next=newHead;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
}