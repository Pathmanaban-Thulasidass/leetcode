class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        Arrays.sort(properties,(a,b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int maxAttack = 0;
        int maxDefence = 0;
        int count = 0;
        for(int i=n-1;i>=0;i--){
            if(maxDefence < properties[i][1]){
                maxDefence = properties[i][1];
                maxAttack = properties[i][0];
            }
            if(maxAttack > properties[i][0] && maxDefence > properties[i][1]){
                count++;
            }
        }
        return count;
    }
}