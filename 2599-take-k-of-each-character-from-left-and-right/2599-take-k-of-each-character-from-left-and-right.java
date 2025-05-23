class Solution {
    public int takeCharacters(String s, int k) {
        if(k == 0)
            return 0;
        int n = s.length();
        int left = 0;
        int aFreq[] = new int[n];
        int bFreq[] = new int[n];
        int cFreq[] = new int[n];
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int innerACount = 0;
        int innerBCount = 0;
        int innerCCount = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == 'a'){
                aCount++;
            }
            else if(ch == 'b'){
                bCount++;
            }
            else{
                cCount++;
            }
            aFreq[i] = aCount;
            bFreq[i] = bCount;
            cFreq[i] = cCount;
        }
        if(aCount < k || bCount < k || cCount < k)
            return -1;
        int reqAFromRight = k;
        int reqBFromRight = k;
        int reqCFromRight = k;
        int rightPtr = n;
        rightPtr = Math.min(rightPtr,binarySearch(aCount - reqAFromRight + 1,n,aFreq));
        rightPtr = Math.min(rightPtr,binarySearch(bCount - reqBFromRight + 1,n,bFreq));
        rightPtr = Math.min(rightPtr,binarySearch(cCount - reqCFromRight + 1,n,cFreq));
        ans = Math.min(ans,n - rightPtr);
        while(left < n){
            char ch = s.charAt(left);
            if(ch == 'a'){
                innerACount++;
            }
            else if(ch == 'b'){
                innerBCount++;
            }
            else{
                innerCCount++;
            }
            rightPtr = n;
            reqAFromRight = k - innerACount;
            reqBFromRight = k - innerBCount;
            reqCFromRight = k - innerCCount;
            if(reqAFromRight > 0){
                rightPtr = Math.min(rightPtr,binarySearch(aCount - reqAFromRight + 1,n,aFreq));
            }
            if(reqBFromRight > 0){
                rightPtr = Math.min(rightPtr,binarySearch(bCount - reqBFromRight + 1,n,bFreq));
            }
            if(reqCFromRight > 0){
                rightPtr = Math.min(rightPtr,binarySearch(cCount - reqCFromRight + 1,n,cFreq));
            }
            ans = Math.min(ans,left + (n - rightPtr) + 1);
            left++;
        }
        return ans;
    }
    public int binarySearch(int k,int n,int prefixSum[]){
        int low = 0;
        int high = n - 1;
        int index = n;
        while(low <= high){
            int mid = (low + high)/2;
            if(prefixSum[mid] >= k){
                index = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return index;
    }
}