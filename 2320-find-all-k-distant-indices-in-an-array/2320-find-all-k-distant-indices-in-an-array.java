class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        while(right < n){
            while(nums[right] == key && (right - left) > k){
                left++;
            }
            if(nums[right] == key){
                while(left <= right){
                    ans.add(left);
                    left++;
                }
                boolean flag = false;
                for(int i=right+1;i<=Math.min(right+k,n-1);i++){
                    if(nums[i] == key){
                        right = i;
                        left = i;
                        flag = true;
                        break;
                    }
                    ans.add(i);
                }
                if(!flag){
                    right += k + 1;
                    left = right;
                }
            }
            else{
                right++;
            }
        }
        return ans;
    }
}