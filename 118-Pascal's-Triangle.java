class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outer = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> inner = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    inner.add(1);
                }
                else{
                    inner.add(outer.get(i-1).get(j-1) + outer.get(i-1).get(j));
                }
            }
            outer.add(inner);
        }
        return outer;
    }
}