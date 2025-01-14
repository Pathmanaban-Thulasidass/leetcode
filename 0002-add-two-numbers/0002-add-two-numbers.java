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
        int carry = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head = null;
        ListNode tail = null;
        ListNode newNode = null;
        int digit = 0;
        while(temp1 != null && temp2 != null){
            digit = temp1.val + temp2.val + carry;
            carry = digit / 10;
            if(head == null){
                newNode = new ListNode(digit % 10);
                head = newNode;
                tail = newNode;
            }
            else{
                newNode = new ListNode(digit % 10);
                tail.next = newNode;
                tail = newNode;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp1 != null){
            digit = temp1.val + carry;
            carry = digit / 10;
            newNode = new ListNode(digit % 10);
            tail.next = newNode;
            tail = newNode;

            temp1 = temp1.next;
        }
        while(temp2 != null){
            digit = temp2.val + carry;
            carry = digit / 10;
            newNode = new ListNode(digit % 10);
            tail.next = newNode;
            tail = newNode;

            temp2 = temp2.next;
        }
        if(carry > 0){
            newNode = new ListNode(carry);
            tail.next = newNode;
            // tail = newNode;
        }
        return head;
    }
}