class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int [] ans = new int[n1];
        Stack<Integer> monoSt = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=n2-1;i>=0;i--){
            while(!monoSt.isEmpty() && monoSt.peek() < nums2[i]){
                monoSt.pop();
            }
            if(monoSt.isEmpty())
                map.put(nums2[i],-1);
            else
                map.put(nums2[i],monoSt.peek());
            monoSt.push(nums2[i]);
        }
        for(int i=0;i<n1;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}