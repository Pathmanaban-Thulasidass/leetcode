int countSeniors(char ** details, int detailsSize){
    int c = 0;
    for(int i=0;i<detailsSize;i++){
        int f = details[i][11] - '0';
        int s = details[i][12] - '0';
        if((f*10 + s) > 60)
            c++;
    }
    return c;
}