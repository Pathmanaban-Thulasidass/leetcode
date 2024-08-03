class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int freq[] = new int[1001];
        int n = target.length;
        int m = arr.length;
        if(n != m)
            return false;
        for(int i=0;i<n;i++){
            freq[target[i]]++;
            freq[arr[i]]--;
        }
        for(int i=0;i<n;i++){
            if(freq[target[i]] != 0 || freq[arr[i]]  != 0)
                return false;
        }
        return true;
    }
}