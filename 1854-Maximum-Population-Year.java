class Solution {
    public int maximumPopulation(int[][] logs) {
        int n = logs.length;
        int year = -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,logs[i][0]);
            max = Math.max(max,logs[i][1]);
        }
        int size = (max - min) + 1;
        int arr[] = new int[size + 1];
        for(int i=0;i<n;i++){
            arr[logs[i][0] - min]++;
            arr[(logs[i][1] - min)]--;
        }
        int prefixSum[] = new int[size + 1];
        prefixSum[0] = arr[0];
        max = arr[0];
        year = min;
        for(int i=1;i<size;i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
            if(max < prefixSum[i]){
                max = prefixSum[i];
                year = i + min;
            }
        }
        return year;
    }
}