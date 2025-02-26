class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int temp[][] = new int[n][2];
        int count = 0;
        double max = -1e9;
        for(int i=0;i<n;i++){
            temp[i] = new int[]{position[i],speed[i]};
        }
        Arrays.sort(temp,(a,b) -> b[0] - a[0]);
        for(int i=0;i<n;i++){
            double dis = target - temp[i][0];
            double spd = temp[i][1];//speed
            double time = (dis / spd);
            if(max < time){
                count++; 
                max = time;
            }
        }
        return count;
    }
}