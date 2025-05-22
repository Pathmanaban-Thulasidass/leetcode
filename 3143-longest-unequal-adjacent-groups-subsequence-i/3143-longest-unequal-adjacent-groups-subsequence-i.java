class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        int lastGroup = -1;
        for(int i=0;i<n;i++){
            if(lastGroup != groups[i]){
                ans.add(words[i]);
                lastGroup = groups[i];
            }
        }
        return ans;
    }
}