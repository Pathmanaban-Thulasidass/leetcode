class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[1] + a[2] == b[1] + b[2]){
                return b[1] - a[1];
            }
            else{
                return (a[1] + a[2]) - (b[1] + b[2]); 
            }
        });
        int size = 0;
        for(int i=0;i<n;i++){
            int temp = nums.get(i).size();
            size += temp;
            for(int j=0;j<temp;j++){
                pq.add(new int[]{nums.get(i).get(j),i,j});
            }
        }
        int ans[] = new int[size];
        for(int i=0;i<size;i++){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}