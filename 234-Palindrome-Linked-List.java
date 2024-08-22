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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isOdd = true;
        Stack<Integer> st = new Stack<>();
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            if(fast == null)
                isOdd = false;
            st.push(slow.val);
            slow = slow.next;
        }
        if(isOdd){
            slow = slow.next;
        }
        while(slow != null){
            if(st.pop() != slow.val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}