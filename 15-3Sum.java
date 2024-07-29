class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Brute Force Approach

        // Arrays.sort(nums);
        // Set<List<Integer>> ans = new HashSet<>();
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         for(int k=j+1;k<n;k++){
        //             if(nums[i] + nums[j] + nums[k] == 0){
        //                 List<Integer> inner = new ArrayList<>();
        //                 inner.add(nums[i]);
        //                 inner.add(nums[j]);
        //                 inner.add(nums[k]);
        //                 ans.add(inner);
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(ans);

        //Better Approach

        // Set<List<Integer>> ans = new HashSet<>();
        // int k;
        // int n = nums.length;
        // Arrays.sort(nums);
        // for(int i=0;i<n;i++){
        //     Set<Integer> check = new HashSet<>();
        //     for(int j=i+1;j<n;j++){
        //         k = -1 * (nums[i] + nums[j]);
        //         if(check.contains(k)){
        //             List<Integer> inner = new ArrayList<>();
        //             inner.add(nums[i]);
        //             inner.add(nums[j]);
        //             inner.add(k);
        //             // Collections.sort(inner);
        //             ans.add(inner);
        //         }
        //         check.add(nums[j]);
        //     }
        // }
        // return new ArrayList<>(ans);

        //Optimal Approach
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1;
            int k = n - 1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else{
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
}