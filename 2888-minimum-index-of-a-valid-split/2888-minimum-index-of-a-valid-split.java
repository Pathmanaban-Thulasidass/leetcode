class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int count = 0;
        int dominatEle = -1;
        int totalDominantCount = 0;
        int preDominantCount = 0;
        for(int i=0;i<n;i++){
            if(count == 0){
                dominatEle = nums.get(i);
                count = 1;
            }
            else if(dominatEle == nums.get(i)){
                count++;
            }
            else{
                count--;
            }
        }
        for(int i=0;i<n;i++){
            if(dominatEle == nums.get(i)){
                totalDominantCount++;
            }
        }
        for(int i=0;i<n;i++){
            if(dominatEle == nums.get(i)){
                preDominantCount++;
            }
            if((preDominantCount > ((i+1) / 2)) && ((totalDominantCount - preDominantCount) > ((n - i - 1) / 2)))
                return i;
        }
        return -1;
    }
}