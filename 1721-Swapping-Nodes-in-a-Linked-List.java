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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        ListNode temp = head;
        int c = 0;
        while(temp != null){
            c++;
            if(c < k)
                left = left.next;
            if(c > k)
                right = right.next;
            temp = temp.next;
        }
        int t = left.val;
        left.val = right.val;
        right.val = t;
        return head;
    }
}