class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Pair[] pairs = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            if(n>0){
                int f = 1;
                int mappedValue = 0;
                while(n>0){
                    mappedValue += mapping[n%10] * f;
                    f *= 10; 
                    n /= 10;
                }
                pairs[i] = new Pair(nums[i],mappedValue);
            }
            else{
                pairs[i] = new Pair(nums[i],mapping[0]);
            }            
        }
        Arrays.sort(pairs,(a,b) -> a.mappedVal - b.mappedVal);
        int j = 0;
        for(Pair i: pairs){
            nums[j++] = i.val; 
        }
        return nums;
    }
}

class Pair{
    int val;
    int mappedVal;
    public Pair(int val, int mappedVal){
        this.val = val;
        this.mappedVal = mappedVal;
    }
}