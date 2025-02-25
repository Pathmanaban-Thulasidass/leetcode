class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }
        int size = map.size();
        int tempArr[] = new int[size];
        int i = 0;
        for(int key : map.keySet()){
            tempArr[i++] = map.get(key);
        }
        if(k == 0)
            return size;
        Arrays.sort(tempArr);
        for(i=0;i<size;i++){
            if(tempArr[i] <= k){
                k -= tempArr[i];
            }
            else{
                if(k > 0){
                    return size - i;
                }
            }
            if(k == 0)
                return size - i - 1;

        }
        return -1;
    }
}