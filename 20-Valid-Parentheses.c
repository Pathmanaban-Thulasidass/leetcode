bool isValid(char* s) {
    int a = strlen(s);
    int stack[a];
    int top = -1;
    for(int i=0;i<strlen(s);i++){
        if(s[i] == '(' || s[i] == '{' || s[i] == '['){
           stack[++top] = s[i];
        }
        else if(s[i] == ')' || s[i] == '}' || s[i] == ']'){
            if(top < 0)
                return false;
            if((s[i] == ')' && stack[top] == '(') || (s[i] == '}' && stack[top] == '{') || (s[i] == ']' && stack[top] == '[')){
                --top;
            }
            else
                return false;
        }
        else
            return false;
    }
    return top == -1;
}