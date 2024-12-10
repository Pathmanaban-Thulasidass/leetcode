class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        int n = candies.length;
        for(int i=0;i<n;i++){
            max = Math.max(max,candies[i]);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(candies[i] + extraCandies >= max)
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}