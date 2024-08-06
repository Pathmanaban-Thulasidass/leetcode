class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];
        int n = word.length();
        int noOfClicked = 0;
        for(int i=0;i<n;i++){
            freq[word.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        int c = 0;
        int mul = 1;
        for(int i=25;i>=0;i--){
            if(freq[i] != 0){
                noOfClicked += freq[i] * mul;
                c++;
                if(c == 8){
                    mul++;
                    c = 0;
                }
            }
        }
        return noOfClicked;
    }
}