class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int removeCost = 0;
        Stack<int[]> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                st.push(new int[]{(colors.charAt(i) - 'a'),i});
            }
            else{
                if(st.peek()[0] == colors.charAt(i) - 'a'){
                    int[] stEle = st.pop();
                    if(neededTime[stEle[1]] < neededTime[i]){
                        removeCost += neededTime[stEle[1]];
                        st.push(new int[]{(colors.charAt(i) - 'a'),i});
                    }
                    else{
                        removeCost += neededTime[i];
                        st.push(stEle);
                    }
                }
                else{
                    st.push(new int[]{(colors.charAt(i) - 'a'),i});
                }
            }
        }
        return removeCost;
    }
}