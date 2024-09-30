class CustomStack {
    int top = -1;
    int maxSize;
    int stack[];
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    
    public void push(int x) {
        if(top + 1 != maxSize){
            stack[++top] = x;
        }
    }
    
    public int pop() {
        if(top == -1)
            return -1;
        return stack[top--];     
    }
    
    public void increment(int k, int val) {
        if(k <= top){
            for(int i=0;i<k;i++){
                stack[i] += val;
            }
        }
        else{
            for(int i=0;i<=top;i++){
                stack[i] += val;
            }
        }
    }
}