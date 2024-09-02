class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        long tempSum = 0;
        for(int i=0;i<chalk.length;i++){
            sum += chalk[i];
        }
        k = (int)(k % sum);
        // System.out.println(k);
        for(int i=0;i<chalk.length;i++){
            tempSum += chalk[i];
            if(tempSum > k){
                return i;
            }
        }
        return -1;
    }
}