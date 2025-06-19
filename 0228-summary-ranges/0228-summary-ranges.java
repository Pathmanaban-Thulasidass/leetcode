class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if(n == 0)
            return ans;
        int min = nums[0];
        int max = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] == max + 1){
                max = nums[i];
            }
            else{
                if(min != max)
                    ans.add("" + min + "->" + max);
                else  
                    ans.add("" + min);
                min = nums[i];
                max = nums[i];
            }
        }
        if(min != max)
            ans.add("" + min + "->" + max);
        else  
            ans.add("" + min);
        return ans;
    }
}