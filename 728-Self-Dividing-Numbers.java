class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(check(i))
                ans.add(i);
        }
        return ans;
    }
    public boolean check(int n){
        int t = n;
        while(n!=0){
            int r = n%10;
            if(r == 0) return false;
            if(t%r != 0)
                return false;
            n /= 10;
        }
        return true;
    }
}