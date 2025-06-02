class Solution {
    public int candy(int[] ratings) {
        //Slope Method
        int n = ratings.length;
        int totalCandies = 1; // Because first child is even equal to neighbors or greater or lesser it must have 1
        int i = 1;
        while(i < n){
            if(ratings[i] == ratings[i-1]){
                totalCandies += 1;
                i++;
                continue;
            }
            int peek = 1;
            while(i < n && ratings[i] > ratings[i-1]){
                peek += 1;
                totalCandies += peek;
                i++;
            }
            int down = 1;
            while(i < n && ratings[i] < ratings[i-1]){
                totalCandies += down;
                down++;
                i++;
            }
            if(down > peek){
                totalCandies += (down - peek);
            }
        }
        return totalCandies;
    }
}