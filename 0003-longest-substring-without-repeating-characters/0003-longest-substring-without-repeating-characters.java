class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0)
            return 0;
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        while(right < n){
            while(map.get(s.charAt(right)) != null){
                map.put(s.charAt(left),map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            map.put(s.charAt(right),1);
            max = Math.max(max,right - left + 1);
            right++;
        }
        return max;
    }
}