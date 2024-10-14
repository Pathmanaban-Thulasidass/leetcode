class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0)
            return 0;
        Queue<Character> queue = new LinkedList<>();
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        while(right < n){
            if(!queue.contains(s.charAt(right))){
                queue.add(s.charAt(right));
            }
            else{
                while(queue.contains(s.charAt(right))){
                    left++;
                    queue.poll();
                }
                queue.add(s.charAt(right));
            }
            max = Math.max(max,queue.size());
            right++;
        }
        return max;
    }
}