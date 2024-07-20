int divideCount(int arr[],int n,int d){
    int c = 0;
    for(int i=0;i<n;i++){
        if(arr[i]%d == 0)
            c++;
    }
    return c;
}
int maxDivScore(int* nums, int numsSize, int* divisors, int divisorsSize){
    int maxDiv = 0;
    int minValue = 99999999999;
    int div;
    for(int i=0;i<divisorsSize;i++){
        div = divideCount(nums,numsSize,divisors[i]);
        if(maxDiv < div){
            maxDiv = div;
            minValue = divisors[i];
        }
        else if(maxDiv == div){
            if(minValue > divisors[i])
                minValue = divisors[i];
        }
    }
    return minValue;
}