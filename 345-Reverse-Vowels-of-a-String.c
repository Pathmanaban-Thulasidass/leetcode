bool isVowel(char c){
    c = tolower(c);
    return c == 'a' || c == 'e' || c == 'i' || c == 'o'|| c == 'u';
}
char* reverseVowels(char* s) {
    int l = strlen(s);
    int left = 0;
    int right = l - 1;
    while(left < l && !isVowel(s[left])){
        left++;
    }
    while(right >= 0 && !isVowel(s[right])){
        right--;
    }
    while(left < right){
        char t = s[left];
        s[left++] = s[right];
        s[right--] = t;
        while(left < l && !isVowel(s[left])){
            left++;
        }
        while(right >= 0 && !isVowel(s[right])){
            right--;
        }
    }
    return s;
}