class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int ope = 0;
        int freq[] = new int[101];
        int noOfDuplicates = 0;
        int ptr = 0;
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        for(int i=0;i<101;i++){
            if(freq[i] > 1){
                noOfDuplicates++;
            }
        }
        if(noOfDuplicates == 0)
            return 0;
        while(ptr + 2 < n){
            ope++;
            if(freq[nums[ptr]] == 2)
                noOfDuplicates--;
            freq[nums[ptr]]--;

            if(freq[nums[ptr + 1]] == 2)
                noOfDuplicates--;
            freq[nums[ptr + 1]]--;

            if(freq[nums[ptr + 2]] == 2)
                noOfDuplicates--;
            freq[nums[ptr + 2]]--;
            if(noOfDuplicates == 0)
                return ope;
            ptr += 3;
        }
        return noOfDuplicates == 0 ? ope : ope + 1;
    }
}