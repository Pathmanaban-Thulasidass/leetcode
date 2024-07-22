bool check(int* nums, int numsSize) {
    int c = 0;
    for(int i=0;i<numsSize-1;i++){
        if(nums[i] > nums[i+1])
            c++;
        if(c > 1)
            return false;
    }
    return c == 0 || nums[0] >= nums[numsSize-1] ;
}