class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int size = items.length;
        int n = queries.length;
        int ans[] = new int[n];
        Arrays.sort(items,(a,b) -> a[0] - b[0]);
        int preMax[] = new int[size];
        int max = 0;
        for(int i=0;i<size;i++){
            max = Math.max(max,items[i][1]);
            preMax[i] = max;
        }
        for(int i=0;i<n;i++){
            int index = binarySearch(queries[i],size,items);
            if(index == -1){
                ans[i] = 0;
            }
            else{
                ans[i] = preMax[index];
            }
        }
        return ans;
    }
    public int binarySearch(int k,int n,int[][] items){
        int low = 0;
        int high = n - 1;
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(items[mid][0] <= k){
                index = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return index;
    }
}