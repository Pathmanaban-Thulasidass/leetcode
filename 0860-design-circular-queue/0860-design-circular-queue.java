class MyCircularQueue {
    int k;
    int arr[];
    int front = -1;
    int rear = -1;
    public MyCircularQueue(int k) {
        this.k = k;
        arr = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(((rear == k - 1) && (front == 0)) || (front == rear + 1))
            return false;
        if(rear == -1 && front == -1){
            rear = 0;
            front = 0;
        }
        else if((rear == k - 1) && (front != 0)){
            rear = 0;
        }
        else{
            rear++;
        }
        arr[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(front == -1)
            return false;
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else if(front == k - 1){
            front = 0;
        }
        else{
            front++;
        }
        return true;
    }
    
    public int Front() {
        if(front == -1)
            return -1;
        return arr[front];
    }
    
    public int Rear() {
        if(rear == -1)
            return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        return ((front == 0) && (rear == k - 1)) || (front == rear + 1); 
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */