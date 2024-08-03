class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        int freq[] = new int[128];
        for(char c : s.toCharArray()){
            freq[c]++;
        }
        StringBuffer sb = new StringBuffer();
        while(sb.length() < n){
            int max = 0;
            int c = 0;
            for(int i=0;i<128;i++){
                if(max < freq[i]){
                    max = freq[i];
                    c = i;
                }
            }
            while(freq[c] > 0){
                sb.append((char)c);
                freq[c]--;
            }
        }
        return sb.toString();
    }
}