class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int prefixXorArr[] = new int[arr.length];
        int prefixXor = 0;
        for(int i=0;i<arr.length;i++){
            prefixXor^=arr[i];
            prefixXorArr[i] = prefixXor;
        }
        for(int i=0;i<queries.length;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            if(left == 0)
                ans[i] = prefixXorArr[right];
            else
                ans[i] = prefixXorArr[right] ^ prefixXorArr[left - 1];
        }
        return ans;
    }
}