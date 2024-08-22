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
    public ListNode doubleIt(ListNode head) {
        head = reverseList(head);
        int carry = 0;
        ListNode temp = head;
        while(temp != null){
            int ans = temp.val * 2;
            ans += carry;
            temp.val = ans % 10;
            carry = ans / 10;
            temp = temp.next;
        }
        head = reverseList(head);
        if(carry > 0){
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode temp = head;
        ListNode front = null;
        ListNode prev = null;
        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}