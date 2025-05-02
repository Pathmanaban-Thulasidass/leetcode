class Solution {
    public String pushDominoes(String dominoes) {
        char arr[] = dominoes.toCharArray(); 
        int n = dominoes.length();
        int left = 0;
        int right = 0;
        while(right < n){
            while(left < n && arr[left] == '.'){
                left++;
            }
            right = left + 1;
            while(right < n && arr[right] == '.'){
                right++;
            }
            if(right < n && arr[left] == 'R' && arr[right] == 'L'){
                int tempLeft = left + 1;
                int tempRight = right - 1;
                while(tempLeft < tempRight){
                    arr[tempLeft] = 'R';
                    arr[tempRight] = 'L';
                    tempLeft++;
                    tempRight--;
                }
            }
            else if(right < n && arr[left] == 'L' && arr[right] == 'L'){
                int tempLeft = left;
                while(tempLeft < right){
                    arr[tempLeft] = 'L';
                    tempLeft++;
                }
            }
            else if(right < n && arr[left] == 'R' && arr[right] == 'R'){
                int tempLeft = left;
                while(tempLeft < right){
                    arr[tempLeft] = 'R';
                    tempLeft++;
                }
            }
            left = right;
        }
        int first = 0;
        while(first < n && arr[first] == '.'){
            first++;
        }
        if(first < n && arr[first] == 'L'){
            for(int i=0;i<first;i++){
                arr[i] = 'L';
            }
        }
        int last = n - 1;
        while(last >= 0 && arr[last] == '.'){
            last--;
        }
        if(last >= 0 && arr[last] == 'R'){
            for(int i=last+1;i<n;i++){
                arr[i] = 'R';
            }
        }
        return new String(arr);
    }
}