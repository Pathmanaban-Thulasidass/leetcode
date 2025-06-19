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
            return head;
        ListNode ans = null;
        ListNode prev = null;
        ListNode temp = head;
        while(temp != null){
            boolean flag = false;
            while(temp.next != null && temp.val == temp.next.val){
                flag = true;
                temp = temp.next;
            }
            if(!flag){
                if(prev == null){
                    ans = temp;
                }
                else{
                    prev.next = temp;
                }
                prev = temp;
            }
            temp = temp.next;
        }
        if(prev != null)
            prev.next = null;
        return ans;
    }
}