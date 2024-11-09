class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        long prefixSum1[] = new long[n1];
        long prefixSum2[] = new long[n2];
        List<int[]> junc = new ArrayList<>();
        long sum = 0;
        int juncSum = 0;
        prefixSum1[0] += nums1[0];
        for(int i=1;i<n1;i++){
            prefixSum1[i] += nums1[i] + prefixSum1[i-1];
        }
        prefixSum2[0] += nums2[0];
        for(int i=1;i<n2;i++){
            prefixSum2[i] += nums2[i] + prefixSum2[i-1];
        }
        // System.out.println(Arrays.toString(prefixSum1));
        // System.out.println(Arrays.toString(prefixSum2));
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < n1 && ptr2 < n2){
            if(nums1[ptr1] == nums2[ptr2]){
                junc.add(new int[]{ptr1,ptr2});
                juncSum += nums1[ptr1];
                ptr1++;
                ptr2++;
            }
            else if(nums1[ptr1] < nums2[ptr2]){
                ptr1++;
            }
            else{
                ptr2++;
            }
        }
        if(junc.size() == 0){
            return prefixSum1[n1 - 1] > prefixSum2[n2 - 1] ? (int)(prefixSum1[n1 - 1] % (1e9+7)) : (int)(prefixSum2[n2 - 1] % (1e9 + 7));  
        }
        int firstJun1 = junc.get(0)[0];
        int firstJun2 = junc.get(0)[1];
        if(prefixSum1[firstJun1] > prefixSum2[firstJun2]){
            sum = (long)((sum + prefixSum1[firstJun1]) % (1e9 + 7));
        }
        else{
            sum = (long)((sum + prefixSum2[firstJun2]) % (1e9 + 7));
        }
        int lastJun1 = firstJun1;
        int lastJun2 = firstJun2;
        junc.remove(0);
        for(int [] singleJunc : junc){
            int curJun1 = singleJunc[0];
            int curJun2 = singleJunc[1];
            long temp1 = prefixSum1[curJun1] - prefixSum1[lastJun1];
            long temp2 = prefixSum2[curJun2] - prefixSum2[lastJun2];
            if(temp1 < temp2){
                sum = (long)((sum + temp2) % (1e9 + 7));
            }
            else{
                sum = (long)((sum + temp1) % (1e9 + 7));
            }
            lastJun1 = curJun1;
            lastJun2 = curJun2;
        }
        long temp1 = prefixSum1[n1 - 1] - prefixSum1[lastJun1];
        long temp2 = prefixSum2[n2 - 1] - prefixSum2[lastJun2];
        if(temp1 < temp2){
            sum = (long)((sum + temp2) % (1e9 + 7));
        }
        else{
            sum = (long)((sum + temp1) % (1e9 + 7));
        }
        return (int)sum;
    }
}