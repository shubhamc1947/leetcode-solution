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
    public int pairSum(ListNode head) {
        // calculate the size of List
        int size = 0;
        ListNode it = head;
        while (it != null) {
            size++;
            it = it.next;
        }

        // split the given list into two lists with the same size
        ListNode pre = null;
        it = head;
        for (int i = 0; i < size / 2; i++) {
            ListNode tp = it.next;
            it.next = pre;
            pre = it;
            it = tp;
        }
        ListNode head1 = pre, head2 = it;

        // find the max twin sum
        int max = 0;
        while (head1 != null) {
            max = Math.max(head1.val + head2.val, max);
            head1 = head1.next;
            head2 = head2.next;
        }
        return max;
    }
}