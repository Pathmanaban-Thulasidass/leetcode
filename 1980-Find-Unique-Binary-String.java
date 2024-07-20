class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int l = nums[0].length();
        boolean decimal[] = new boolean[1 << l];
        int val = 0;
        for(int i=0;i<nums.length;i++){
            val = Integer.parseInt(nums[i],2);
            decimal[val] = true;
        }
        for(int i=0;i< (1 << nums[0].length());i++){
            if(!decimal[i]) {
                StringBuffer sb = new StringBuffer(Integer.toString(i,2));
                while(l - sb.length() > 0){
                    sb.insert(0,"0");
                }
                return sb.toString();
            }
        }
        return null;
    }
}