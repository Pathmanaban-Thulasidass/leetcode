class Solution {
    public int longestPalindrome(String[] words) {
        int n = words.length;
        int len = 0;
        int grid[][] = new int[26][26];
        boolean extras = false;
        for(int i=0;i<n;i++){
            int fisrt = words[i].charAt(0) - 'a';
            int second = words[i].charAt(1) - 'a';
            grid[fisrt][second]++;
        }
        for(int i=0;i<n;i++){
            int fisrt = words[i].charAt(0) - 'a';
            int second = words[i].charAt(1) - 'a';
            if(fisrt == second){
                if(grid[fisrt][second] != -1){
                    len += grid[second][fisrt] / 2;
                    if(grid[fisrt][second] % 2 != 0){
                        extras = true;
                    }
                }
            }
            else{
                if(grid[fisrt][second] != -1 && grid[second][fisrt] != -1){
                    int freq = Math.min(grid[second][fisrt],grid[fisrt][second]);
                    len += freq;
                }
            }
            grid[fisrt][second] = -1;
            grid[second][fisrt] = -1;
        }
        len *= 4;
        if(extras)
            len += 2;
        return len;
    }
}