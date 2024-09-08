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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode temp = head;
        ListNode front = null;
        ListNode tempHead = null;
        int j = 0;
        int size = 0;
        int c = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        temp = head;
        int q = size / k;
        int r = size % k;
        if(q == 0){
            while(temp != null){
                front = temp.next;
                temp.next = null;
                ans[j++] = temp;
                temp = front;
            }
            return ans;
        }
        int req = q;
        if(r > 0){
            req += 1;
            r--;
        }
        tempHead = head;
        while(temp != null){
            c++;
            front = temp.next;
            if(c == req){
                ans[j++] = tempHead;
                tempHead = front;
                req = q;
                if(r > 0){
                    req += 1;
                    r--;
                }
                c = 0;
                temp.next = null;
            }
            temp = front;
        }
        return ans;
    }
}