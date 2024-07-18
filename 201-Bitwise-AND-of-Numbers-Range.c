int rangeBitwiseAnd(long left, long right) {
    long ans = left;
    for(long i=left+1;i<=right;i++){
        ans &= i;
        if(ans == 0)
            return 0; 
    }
    return (int)ans;
}