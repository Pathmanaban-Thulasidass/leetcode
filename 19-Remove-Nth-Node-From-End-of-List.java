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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null){
            if(isDeletableNode(temp,n)){
                if(prev == null){
                    head = head.next;
                    break;
                }
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;        
    }
    public boolean isDeletableNode(ListNode current,int n){
        for(int i=1;i<=n;i++){
            current = current.next;
            if(current == null){
                return true;
            }
        }
        return false;
    }
}