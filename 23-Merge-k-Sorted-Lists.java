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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = lists.length;
        for(int i=0;i<n;i++){
            ListNode temp = lists[i];
            while(temp != null){
                pq.add(temp.val);
                temp = temp.next;
            }
        }
        if(pq.isEmpty())
            return null;
        ListNode head = new ListNode(pq.poll());
        ListNode tail = head;
        while(!pq.isEmpty()){
            ListNode temp = new ListNode(pq.poll());
            tail.next = temp;
            tail = temp;
        }
        return head;
    }
}