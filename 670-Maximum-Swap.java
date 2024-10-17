class Solution {
    public int maximumSwap(int num) {
        String s = Integer.toString(num);
        int n = s.length();
        char arr[] = s.toCharArray();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] < arr[j]){
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    int newNum = Integer.parseInt(new String(arr)); 
                    max = Math.max(max,newNum);

                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return max == Integer.MIN_VALUE ? num : max;
    }
}