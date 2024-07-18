bool detectCapitalUse(char* word) {
    int lc = 0;
    int n = strlen(word);
    for(int i=0;i<n;i++){
        if(word[i] >= 'a' && word[i] <= 'z'){
            lc++;
        }
    }
    return lc == 0 || lc == n || (word[0] >= 'A' && word[0] <= 'Z' && (lc + 1 == n));
}