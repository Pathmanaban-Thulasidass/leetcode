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
    public ListNode reverseKGroup(ListNode head, int k) {
        int c = 0;
        ListNode temp = head;
        ListNode start = null;
        ListNode firstJoin = null;
        ListNode lastJoin = null;
        ListNode[] arr = new ListNode[2];
        boolean isHead = true;
        // while(temp != null){
        //     c++;
        //     if(c == left){
        //         start = temp;
        //     }
        //     else if(c + 1 == left){
        //         firstJoin = temp;
        //     }
        //     if(c == right){
        //         lastJoin = temp.next;
        //         arr = reverse(start,temp.next);
        //         break;
        //     }
        //     temp = temp.next;
        // }
        // if(firstJoin != null){
        //     firstJoin.next = arr[0];
        //     arr[1].next = lastJoin;
        //     return head;
        // }
        // else{
        //     arr[1].next = lastJoin;
        //     return arr[0];
        // }
        start = head;
        while(temp != null){
            c++;
            if(c % k == 0){
                // System.out.println(temp.val + \,,,,,,,,,,\);
                lastJoin = temp.next;
                arr = reverse(start,temp.next);
                if(isHead){
                    head = arr[0];
                    isHead = false;
                }
                if(firstJoin != null){
                    firstJoin.next = arr[0];
                    arr[1].next = lastJoin;
                }
                else{
                    arr[1].next = lastJoin;
                }
                firstJoin = arr[1];
                temp = arr[1];
                start = temp.next;
            }
            temp = temp.next;
        }
        return head;
    }
    public ListNode[] reverse(ListNode head,ListNode tail){
        ListNode[] arr = new ListNode[2];
        ListNode prev = null;
        ListNode front = null;
        ListNode temp = head;
        // System.out.println(\-----------------------<<Before>>\);
        // while(temp != tail){
        //     System.out.println(temp.val);
        //     temp = temp.next;
        // }
        // System.out.println(\-----------------------<<Before>>\);
        temp = head;
        while(temp != tail){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        arr[0] = prev;
        arr[1] = head;
        temp = arr[0];
        // System.out.println(\-----------------------<<After>>\);
        // while(temp != null){
        //     System.out.println(temp.val);
        //     temp = temp.next;
        // }
        // System.out.println(\-----------------------<<After>>\);
        return arr;
    }
}