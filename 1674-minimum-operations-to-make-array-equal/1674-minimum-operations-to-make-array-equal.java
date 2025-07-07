class Solution {
    public int minOperations(int n) {
        int count = 0;
        int mid = ((2 * (n - 1)) + 2) / 2; 
        for(int i=0;i<n;i++){
            int val = (2 * i) + 1;
            if(val < mid){
                count += mid - val;
            }
            else
                break;
        }
        return count;
    }
}