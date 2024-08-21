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
import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger num1 = BigInteger.ZERO;
        BigInteger num2 = BigInteger.ZERO;
        BigInteger f1 = BigInteger.ONE;

        while (l1 != null) {
            num1 = num1.add(BigInteger.valueOf(l1.val).multiply(f1));
            f1 = f1.multiply(BigInteger.TEN);
            l1 = l1.next;
        }

        f1 = BigInteger.ONE;

        while (l2 != null) {
            num2 = num2.add(BigInteger.valueOf(l2.val).multiply(f1));
            f1 = f1.multiply(BigInteger.TEN);
            l2 = l2.next;
        }

        BigInteger addedVal = num1.add(num2);

        ListNode head = new ListNode(addedVal.mod(BigInteger.TEN).intValue());
        addedVal = addedVal.divide(BigInteger.TEN);
        ListNode tail = head;

        while (addedVal.compareTo(BigInteger.ZERO) > 0) {
            ListNode temp = new ListNode(addedVal.mod(BigInteger.TEN).intValue());
            tail.next = temp;
            tail = temp;
            addedVal = addedVal.divide(BigInteger.TEN);
        }

        return head;
    }
}