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
    public int getDecimalValue(ListNode head) {
        StringBuffer sb = new StringBuffer();
        ListNode temp = head;
        while(temp != null){
            sb.append(Integer.toString(temp.val));
            temp = temp.next;
        }
        return Integer.parseInt(sb.toString(),2);
    }
}