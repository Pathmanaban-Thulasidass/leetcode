class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int ans[] = new int[n];
        int ones = 1;
        int prefixSum[] = new int[n];
        int suffixSum[] = new int[n];
        int firstOneIndex = -1;
        int lastOneIndex = -1;
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(boxes.charAt(i) == '1'){
                if(!flag){
                    firstOneIndex = i;
                    flag = true;
                }
                lastOneIndex = i;
            }
        }
        if(firstOneIndex != -1 && firstOneIndex < n - 1){
            prefixSum[firstOneIndex + 1] = 1;
        }
        if(lastOneIndex != -1 && lastOneIndex > 0){
            suffixSum[lastOneIndex - 1] = 1;
        }
        if(firstOneIndex == -1 && lastOneIndex == -1)
            return ans;
        for(int i=firstOneIndex + 1;i<n;i++){
            prefixSum[i] = prefixSum[i-1] + ones;
            if(boxes.charAt(i) == '1')
                ones++;
        }
        ones = 1;
        for(int i=lastOneIndex - 1;i>=0;i--){
            suffixSum[i] = suffixSum[i+1] + ones;
            if(boxes.charAt(i) == '1')
                ones++;
        }
        for(int i=0;i<n;i++){
            ans[i] = prefixSum[i] + suffixSum[i];
        }
        return ans;
    }
}