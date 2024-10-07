char stack[100];
int top = -1;
void push(char c){
    stack[++top] = c;
}
void pop(){
    --top;
}
int minLength(char * s){
    push(s[0]);
    for(int i=1;i<strlen(s);i++){
        if((top >= 0 && s[i] == 'B' && stack[top] == 'A') || (top >= 0 && s[i] == 'D' && stack[top] == 'C' )){
            pop();
        }
        else{
            push(s[i]);
        }
    } 
    int ans = top + 1;
    top = -1;
    return ans;
}