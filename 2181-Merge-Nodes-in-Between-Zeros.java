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
    public ListNode mergeNodes(ListNode headPara) {
        ListNode temp = headPara;
        ListNode head = null;
        ListNode tail = null;
        int sum = 0;
        temp = temp.next;
        while(temp != null){
            if(temp.val == 0){
                break;
            }
            sum += temp.val;
            temp = temp.next;
        }
        ListNode newNode = new ListNode(sum);
        head = newNode;
        tail = head;
        temp = temp.next;
        sum = 0;
        while(temp != null){
            if(temp.val == 0){
                newNode = new ListNode(sum);
                tail.next = newNode;
                tail = newNode;
                sum = 0;
            }
            sum += temp.val;
            temp = temp.next;
        }
        return head;
    }
}