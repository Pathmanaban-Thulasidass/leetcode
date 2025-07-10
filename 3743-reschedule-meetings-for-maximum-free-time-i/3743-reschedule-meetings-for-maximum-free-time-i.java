class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> li = new ArrayList<>();
        int lastEnd = 0;
        for(int i=0;i<n;i++){
            li.add(startTime[i] - lastEnd);
            lastEnd = endTime[i];
        }
        li.add(eventTime - lastEnd);
        int left = 0;
        int right = k + 1;
        int size = li.size();
        // k -> events
        // but k + 1 gaps
        int max = 0;
        int sum = 0;
        for(int i=0;i<size && i <= k;i++){
            sum += li.get(i);
        }
        max = sum;
        while(right < size){
            sum += li.get(right);
            sum -= li.get(left);
            max = Math.max(max,sum);
            right++;
            left++;
        }
        return max;
    }
}