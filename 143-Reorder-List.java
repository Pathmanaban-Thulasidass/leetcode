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
    public void reorderList(ListNode head) {
        List<Integer> li = new ArrayList<>();
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            li.add(temp.val);
            temp = temp.next;
            size++;
        }
        int fIndex = 0;
        int lIndex = li.size() - 1;
        int count = 0;
        temp = head;
        while(temp != null){
            if(count % 2 == 0)
                temp.val = li.get(fIndex++);
            else
                temp.val = li.get(lIndex--);
            temp = temp.next;
            count++;
        }
    }
}