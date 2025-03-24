class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        int lastEndMeeting = 0;
        int ans = 0;
        Arrays.sort(meetings,(a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for(int i=0;i<n;i++){
            if(lastEndMeeting < meetings[i][0]){
                ans += (meetings[i][0] - lastEndMeeting - 1);   
            }
            lastEndMeeting = Math.max(meetings[i][1],lastEndMeeting);
        }
        if(lastEndMeeting < days){
            ans += (days - lastEndMeeting);   
        }
        return ans;
    }
}