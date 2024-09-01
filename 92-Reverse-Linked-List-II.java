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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int c = 0;
        ListNode temp = head;
        ListNode start = null;
        ListNode firstJoin = null;
        ListNode lastJoin = null;
        ListNode[] arr = new ListNode[2];
        while(temp != null){
            c++;
            if(c == left){
                start = temp;
            }
            else if(c + 1 == left){
                firstJoin = temp;
            }
            if(c == right){
                lastJoin = temp.next;
                arr = reverse(start,temp.next);
                break;
            }
            temp = temp.next;
        }
        if(firstJoin != null){
            firstJoin.next = arr[0];
            arr[1].next = lastJoin;
            return head;
        }
        else{
            arr[1].next = lastJoin;
            return arr[0];
        }
    }
    public ListNode[] reverse(ListNode head,ListNode tail){
        ListNode[] arr = new ListNode[2];
        ListNode prev = null;
        ListNode front = null;
        ListNode temp = head;
        while(temp != tail){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        arr[0] = prev;
        arr[1] = head;
        return arr;
    }
    
}