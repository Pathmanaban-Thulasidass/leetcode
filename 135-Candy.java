class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int arr[] = new int[n];//Left
        int arr1[] = new int[n];//Right
        int totalCandies = 0;
        //Comparing only with Left Neighour
        arr[0] = 1;
        for(int i=1;i<n;i++){
            if(ratings[i] > ratings[i-1]){
                arr[i] = arr[i-1] + 1;
            }
            else{
                arr[i] = 1;
            }
        }
        //Now Compare with only Right Neighbour
        arr1[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                arr1[i] = arr1[i+1] + 1;
            }
            else
                arr1[i] = 1;
            totalCandies += Math.max(arr[i],arr1[i]);
        }
        totalCandies += Math.max(arr[n-1],arr1[n-1]);
        return totalCandies;
    }
}