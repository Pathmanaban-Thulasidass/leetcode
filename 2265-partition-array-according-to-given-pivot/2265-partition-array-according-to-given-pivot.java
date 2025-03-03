class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> smaller = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();
        int pivotCount = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == pivot)
                pivotCount++;
            else if(nums[i] < pivot)
                smaller.add(nums[i]);
            else
                larger.add(nums[i]);
        }
        int index = 0;
        for(int i=0;i<smaller.size();i++){
            nums[index++] = smaller.get(i);
        }
        for(int i=0;i<pivotCount;i++){
            nums[index++] = pivot;
        }
        for(int i=0;i<larger.size();i++){
            nums[index++] = larger.get(i);
        }
        return nums;
    }
}