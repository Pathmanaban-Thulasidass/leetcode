class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (m > n) return \\;  

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        String result = \\;

        Map<Character, Integer> sMap = new HashMap<>();

        while (right < n) {
            char ch = s.charAt(right);
            if (tMap.containsKey(ch)) {
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

                if (sMap.get(ch) <= tMap.get(ch)) {
                    count++;
                }
            }

            while (count == m) { 
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                if (tMap.containsKey(leftChar)) {
                    sMap.put(leftChar, sMap.get(leftChar) - 1);
                    if (sMap.get(leftChar) < tMap.get(leftChar)) {
                        count--;
                    }
                }
                left++;
            }

            right++;
        }

        return result;
    }
}
