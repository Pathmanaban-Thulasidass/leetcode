class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int freq1[] = new int[10];
        int freq2[] = new int[10];
        int bull = 0;
        int nonBull = 0;
        for(int i=0;i<n;i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bull++;
            }else{
                freq1[secret.charAt(i) - '0']++;
                freq2[guess.charAt(i) - '0']++;
            }
        }
        for(int i=0;i<10;i++){
            nonBull += Math.min(freq1[i],freq2[i]);
        }
        return bull + "A" + nonBull + "B";
    }
}