class Solution {
    public int pivotInteger(int n) {
        int total = (n*(n+1)) / 2;
        return binarySearch(1,n,total);
    }
    public int binarySearch(int low,int high,int total){
        while(low <= high){
            int mid = low + (high - low) / 2;
            int first = (mid *(mid + 1)) / 2;
            int last = total - first + mid;
            if(first == last)
                return mid;
            else if(first < last){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

}