class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if(n == 1)
            return true;
        else if(!set.add(n))
            return false;        
        int temp = 0;
        while(n > 0){
            int r = n % 10;
            temp += r * r;
            n /= 10;
        }
        return isHappy(temp);
    }
}