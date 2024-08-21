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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode temp = head.next;
        ListNode prev = head;
        while(temp != null){
            if(prev.val == temp.val){
                prev.next = temp.next;
            }
            else{
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}