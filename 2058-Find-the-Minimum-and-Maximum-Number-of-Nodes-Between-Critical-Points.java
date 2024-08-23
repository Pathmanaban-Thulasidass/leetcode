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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int []ans = {-1,-1};
        ListNode temp = head;
        ListNode prev = null;
        ListNode front = null;
        int firstNodePos = -1;
        int lastNodePos = -1;
        int curNodePos = -1;
        int minDis = Integer.MAX_VALUE;
        int maxDis = Integer.MIN_VALUE;
        int pos = 0;
        while(temp != null){
            pos++;
            front = temp.next;
            if(prev != null && front != null){
                if(isLocalMaxima(prev,temp,front) || isLocalMinima(prev,temp,front)){
                    curNodePos = pos;
                    if(lastNodePos != -1){
                        if(minDis > (curNodePos - lastNodePos)){
                            minDis = curNodePos - lastNodePos;
                        }
                    }else{
                        firstNodePos = curNodePos;
                    }
                    lastNodePos = curNodePos; 
                }
            }
            prev = temp;
            temp = temp.next;
        }
        if(minDis == Integer.MAX_VALUE ){
            return ans;
        }
        System.out.println(lastNodePos + "     " + firstNodePos);
        maxDis = lastNodePos - firstNodePos;
        ans[0] = minDis;
        ans[1] = maxDis;        
        System.out.println(minDis + "    " + maxDis);
        return ans;

    }
    public boolean isLocalMaxima(ListNode prev,ListNode cur,ListNode front){
        if(prev.val < cur.val && cur.val > front.val){
            return true;
        }
        return false;
    }
    public boolean isLocalMinima(ListNode prev,ListNode cur,ListNode front){
        if(prev.val > cur.val && cur.val < front.val){
            return true;
        }
        return false;
    }
}