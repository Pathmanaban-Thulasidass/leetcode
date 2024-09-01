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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        int len = 1;
        ListNode tail = head;
        ListNode temp = head;
        while(tail.next != null){
            len++;
            tail = tail.next;
        }
        if(k % len == 0)
            return head;
        else
            k = k % len;
        int n = len - k;
        int c = 0;
        tail.next = head;
        while(temp != null){
            c++;
            if(c == n){
                head = temp.next;
                temp.next = null;
            }
            temp = temp.next;
        }
        return head;
    }
}