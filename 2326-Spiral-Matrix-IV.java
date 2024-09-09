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
    public int[][] spiralMatrix(int rs, int cs, ListNode head) {
        int[][] matrix = new int[rs][cs];
        ListNode temp = head;
        for(int i=0;i<rs;i++){
            Arrays.fill(matrix[i], -1);
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m-1;
        int left = 0, right = n - 1;
        while(left <= right && top <= bottom && temp != null){
            //right
            for(int i=left;i<=right && temp != null;i++){
                matrix[top][i] = temp.val;
                temp = temp.next;
            }
            top++;
            //Bottom
            for(int i=top;i<=bottom && temp != null;i++){
                matrix[i][right] = temp.val;
                temp = temp.next;
            }
            right--;
            //Left
            if(top<=bottom){
                for(int i=right;i>=left && temp != null;i--){
                    matrix[bottom][i] = temp.val;
                    temp = temp.next;
                }
                bottom--;
            }
            //Top
            if(left <= right){
                for(int i=bottom;i>=top && temp != null;i--){
                    matrix[i][left] = temp.val;
                    temp = temp.next;
                }
                left++;
            }
        }
        return matrix;
    }
}