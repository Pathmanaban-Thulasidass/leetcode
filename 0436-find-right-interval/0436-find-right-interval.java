class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int ans[] = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(intervals[i][0],i);
        }
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        for(int i=0;i<n;i++){
            if(map.getOrDefault(intervals[i][1],-1) == -1){
                ans[map.get(intervals[i][0])] = binarySearch(intervals[i][1],intervals,map);
            }
            else{
                ans[map.get(intervals[i][0])] = map.get(intervals[i][1]);
            }
        }
        return ans;        
    }
    int binarySearch(int ele,int[][] arr,HashMap<Integer,Integer> map){
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid][0] == ele){
                return map.get(ele);
            }
            else if(arr[mid][0] < ele){
                low = mid + 1;
            }
            else{
                index = map.get(arr[mid][0]);
                high = mid - 1;
            }
        }
        return index;
    }
}