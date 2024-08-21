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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode temp = head.next;
        ListNode pre = head;
        while(temp != null){
            int t = pre.val;
            pre.val = temp.val;
            temp.val = t;
            if(temp.next != null){
                pre = pre.next.next;
                temp = temp.next.next;
            }
            else
                break;
        }
        return head;
    }
}