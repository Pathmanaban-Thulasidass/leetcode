int removeElement(int* nums, int numsSize, int val) {
    int c=0;
    if(numsSize == 0)
        return 0;
    int j=numsSize-1;
    while(nums[j]==val){
        j--;
        if(j<0){
            return 0;
        }
    }
    for(int i=0;i<numsSize;i++){
        if(val == nums[i])
            c++;
    }
    for(int i=0;i<numsSize-c ;i++){
        if(val==nums[i]){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            j--;
        }
        while(nums[j]==val){
        j--;
        if(j<0){
            return 0;
        }
    }  
    }
    return numsSize - c;
}