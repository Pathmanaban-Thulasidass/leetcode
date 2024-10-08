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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        if(list1 == null && list2 == null)
            return null;
        else if(list1 == null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            head = new ListNode(list1.val); 
            list1 = list1.next; 
        }
        else{
            head = new ListNode(list2.val);
            list2 = list2.next;
        }
        ListNode tail = head;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ListNode temp = new ListNode(list1.val);
                tail.next = temp;
                tail = temp;
                list1 = list1.next;
            }
            else if(list1.val > list2.val){
                ListNode temp = new ListNode(list2.val);
                tail.next = temp;
                tail = temp;
                list2 = list2.next;
            }
            else{
                ListNode temp = new ListNode(list1.val);
                tail.next = temp;
                tail = temp;
                list1 = list1.next;
                temp = new ListNode(list2.val);
                tail.next = temp;
                tail = temp;
                list2 = list2.next;
            } 
        }
        while(list1 != null){
            ListNode temp = new ListNode(list1.val);
            tail.next = temp;
            tail = temp;
            list1 = list1.next;
        }
        while(list2 != null){
            ListNode temp = new ListNode(list2.val);
            tail.next = temp;
            tail = temp;
            list2 = list2.next;
        }
        return head;
    }
}