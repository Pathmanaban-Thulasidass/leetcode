class Solution {
    public int minimumPartition(String s, int k) {
        int n = s.length();
        int count = 0;
        long num = 0;
        int ptr = 0;
        int lastIndex = -1;
        while(ptr < n){
            int temp = s.charAt(ptr) - '0';
            num = (num * 10) + temp;
            if(num > k){
                if(lastIndex == ptr)
                    return -1;
                count++;
                num = 0;
                lastIndex = ptr;
            }
            else{
                ptr++;
            }
        }
        return count + 1;
    }
}