class Solution {
    public int strStr(String haystack, String needle) {
        return KMPsearch(haystack,needle);
    }

    public static int[] buildLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0; 
        int i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];  // fall back
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public int KMPsearch(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();
        int[] lps = buildLPS(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < m) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == n) {
                return i - j;
            } else if (i < m && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // fall back
                } else {
                    i++;
                }
            }
        }
        return -1;
    }
}