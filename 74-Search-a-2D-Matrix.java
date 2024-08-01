class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        return binarySearch(matrix,m,0,n*m-1,target);
    }
    boolean binarySearch(int[][] arr,int col,int low,int high,int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid/col][mid%col] == target){
                return true;
            }
            else if(arr[mid/col][mid%col] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }

}