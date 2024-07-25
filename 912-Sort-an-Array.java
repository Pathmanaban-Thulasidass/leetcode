class Solution {
    public int[] sortArray(int[] nums) {
        partition(nums,0,nums.length-1);
        return nums;
    }
    public static void partition(int arr[],int low,int high){
        if(low < high){
            int mid = (low + high)/2;
            partition(arr, low, mid);
            partition(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    public static void merge(int arr[],int low,int mid,int high){
        int left = low;
        int right = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {
            if(arr[left] < arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for(int i=low;i<=high;i++){
            arr[i] = temp.get(i-low);
        }
    }
}