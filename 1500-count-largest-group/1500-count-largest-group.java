class Solution {
    public int countLargestGroup(int n) {
        int freq[] = new int[40];
        int count = 0;
        int maxSize = 0;
        for(int i=1;i<=n;i++){
            int temp = sumTheDigit(i);
            freq[temp]++;
        }
        for(int i=1;i<40;i++){
            maxSize = Math.max(maxSize,freq[i]);
        }
        for(int i=1;i<40;i++){
            if(freq[i] == maxSize)
                count++;
        }
        return count;
    }
    public int sumTheDigit(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}