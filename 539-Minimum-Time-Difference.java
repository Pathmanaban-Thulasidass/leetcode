class Solution {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int arr[] = new int[size];
        int x = 0;
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int dif = 0;
        for(int i=0;i<size;i++){
            String s = timePoints.get(i);
            x = (s.charAt(0) - '0') * 1000 + (s.charAt(1) - '0') * 100 + (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
            arr[i] = ((x/100) * 60) + (x % 100);
        } 
        Arrays.sort(arr);
        for(int i=1;i<size;i++){
            dif = arr[i] - arr[i-1];
            min = Math.min(dif,min);
        }
        dif = (24 * 60) - (arr[size -1] - arr[0]);
        min = Math.min(dif,min);
        return min;
    }
}