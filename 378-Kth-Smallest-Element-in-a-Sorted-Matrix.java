class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                add(matrix[i][j],k,pq);
            }
        }
        return pq.peek();
    }
    public void add(int val,int k,PriorityQueue<Integer> pq){
        if(pq.size() == k && pq.peek() > val){
            pq.poll();
            pq.add(val);
        } 
        else if(pq.size() < k){
            pq.add(val);
        }
    }
}