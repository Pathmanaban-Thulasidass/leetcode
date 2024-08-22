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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null)
            return head;
        int gcd = 1;
        ListNode temp = head;
        ListNode front = null;
        while(temp.next != null){
            front = temp.next;
            gcd = findGCD(temp.val,front.val);
            ListNode newNode = new ListNode(gcd);
            temp.next = newNode;
            newNode.next = front;
            temp = front;
        }
        return head;
    }
    int findGCD(int a,int b){
        int ans = 1;
        int max = Integer.MIN_VALUE;
        if(a < b)
            max = b;
        else
            max = a;
        for(int i=1;i<=max;i++){
            if((a%i) == 0 && (b%i) == 0){
                ans = i;
            }
        }
        return ans;
    }
}