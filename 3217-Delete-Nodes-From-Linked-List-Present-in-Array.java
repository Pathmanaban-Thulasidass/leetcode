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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int [] freq = new int[100001];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        ListNode temp = head;
        ListNode prev = null;
        ListNode front = null;
        while(temp != null){
            if(freq[temp.val] != 1){
                break;
            }
            temp = temp.next;
        }
        head = temp;
        while(temp != null){
            front = temp.next;
            if(freq[temp.val] == 1){
                prev.next = temp.next;
            }
            else
                prev = temp;
            temp = temp.next;
        }
        return head;
    }
}