class StockSpanner {

    Stack<Integer> monoSt;
    List<Integer> nums = new ArrayList<>();
    public StockSpanner() {
        monoSt = new Stack<>();
    }
    
    public int next(int price) {
        nums.add(price);
        while(!monoSt.isEmpty() && nums.get(monoSt.peek()) <= price)
            monoSt.pop();
        if(monoSt.isEmpty()){
            monoSt.push(nums.size() - 1);
            return nums.size();
        }
        else{
            int temp = nums.size() - monoSt.peek() - 1;
            monoSt.push(nums.size() - 1);
            return temp;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */