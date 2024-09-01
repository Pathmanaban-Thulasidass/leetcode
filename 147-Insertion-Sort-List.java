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
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = head;
        ListNode innerTemp = null;
        ListNode minNode = null;
        int min = Integer.MAX_VALUE; 
        while(temp != null){
            innerTemp = temp;
            min = Integer.MAX_VALUE;
            while(innerTemp != null){
                if(min > innerTemp.val){
                    min = innerTemp.val;
                    minNode = innerTemp;
                }
                innerTemp = innerTemp.next;
            }
            int t = temp.val;
            temp.val = minNode.val;
            minNode.val = t;
            temp = temp.next;
        }
        return head;
    }
}