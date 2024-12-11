class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int curGas = 0;
        int start = 0;
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0;i<n;i++){
            curGas += gas[i] - cost[i];
            if(curGas < 0){
                curGas = 0;
                start = i + 1;
            }
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if(totalGas < totalCost)
            return -1;
        return start;
    }
}