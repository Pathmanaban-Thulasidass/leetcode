class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int arr[] = new int[n];//Left
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
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            totalCandies += Math.max(arr[i], right);
        }
        totalCandies += Math.max(arr[n-1],1);
        return totalCandies;
    }
}