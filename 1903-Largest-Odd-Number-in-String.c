char* largestOddNumber(char* num) {
    int i,n = strlen(num);
    for(i=n-1;i>=0;i--){
        if((num[i] - '0')%2 != 0){
            break;
        }
    }
    if(i < n-1)
        num[i+1] = '\0';
    return num;
}