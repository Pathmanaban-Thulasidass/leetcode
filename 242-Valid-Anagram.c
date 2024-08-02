bool isAnagram(char* s, char* t) {
    if(strlen(s) != strlen(t)){
        return false;
    }
    int freq[26] = {0};
    for(int i=0;s[i]!='\\0';i++){
        freq[s[i] - 97]++;
    }
    for(int i=0;t[i]!='\\0';i++){
        freq[t[i] - 97]--;
        if(freq[t[i] - 97] < 0)
            return false;
    }
    for(int i=0;i<26;i++){
        if(freq[i] != 0)
            return false;
    }
    return true;
}