class Solution {
    int max = 0;
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Long,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put((long)arr[i],i);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(map.get((long)arr[i] + arr[j]) != null){
                    helper(arr[j],arr[i] + arr[j],3,map);
                }
            }
        }
        return max;
    }
    public void helper(long n1,long n2,int len,Map<Long,Integer> map){
        max = Math.max(max,len);
        if(map.get(n1 + n2) != null){
            helper(n2,n1 + n2,len + 1,map);
        }
    }
}