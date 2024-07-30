int mySqrt(int x) {
    if(x < 2)
        return x;
    int sqrt = 0;
    int low = 0,high = x;
    while(low <= high){
        int mid = low + (high - low) / 2;
        long long midSq = (long long)mid * mid;
        if(midSq == x)
            return mid;
        else if(midSq < x){
            low = mid + 1;
            sqrt = mid;
        }
        else{
            high = mid -1;
        }
    }
    return sqrt;
}