/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int peekIndex = -1;
        int low = 0;
        int high = n - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            int midVal = mountainArr.get(mid);
            int midBeforeVal = mountainArr.get(mid-1);
            int midAfterVal = mountainArr.get(mid+1);
            if(mid - 1 >= 0 && mid + 1 < n && midBeforeVal < midVal && midVal > midAfterVal){
                peekIndex = mid;
                break;
            }
            else if(mid - 1 >= 0 && mid + 1 < n && midBeforeVal < midVal && midVal < midAfterVal){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        if(mountainArr.get(peekIndex) == target)
            return peekIndex;
        low = 0;
        high = peekIndex;
        while(low <= high){
            int mid = (low + high) / 2;
            int midVal = mountainArr.get(mid);
            if(midVal == target)
                return mid;
            else if(midVal < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        low = peekIndex;
        high = n - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            int midVal = mountainArr.get(mid);
            if(midVal == target)
                return mid;
            else if(midVal > target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}