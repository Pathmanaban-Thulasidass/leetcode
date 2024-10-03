class Solution {
    public int totalHammingDistance(int[] nums) {
        int hammingDis = 0;
        int setCount = 0;
        int n = nums.length;
        for(int i=0;i<32;i++){
            setCount = 0;
            for(int j=0;j<n;j++){
                if(isSet(nums[j],i))
                    setCount++;
            }
            hammingDis += (setCount * (n - setCount));
        }
        return hammingDis;
    }
    public boolean isSet(int n,int index){
        return (n & (1 << index)) != 0;
    }
}