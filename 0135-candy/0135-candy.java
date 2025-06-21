class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ptr = 1;
        int candy[] = new int[n];
        Arrays.fill(candy,1);
        while(ptr < n){
            if(ratings[ptr] > ratings[ptr - 1]){
                candy[ptr] = candy[ptr - 1] + 1;
            }
            ptr++;
        }
        ptr = n - 2;
        int totalCandies = candy[n - 1];
        while(ptr >= 0){
            if(ratings[ptr] > ratings[ptr + 1]){
                candy[ptr] = Math.max(candy[ptr],candy[ptr + 1] + 1);
            }
            totalCandies += candy[ptr];
            ptr--;
        }
        return totalCandies;
    }
}