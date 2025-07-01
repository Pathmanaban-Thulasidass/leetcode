class Solution {
    public int numSplits(String s) {
        int n = s.length();
        Map<Character,Integer> leftMap = new HashMap<>();
        Map<Character,Integer> rightMap = new HashMap<>();
        int count = 0;
        leftMap.put(s.charAt(0),leftMap.getOrDefault(s.charAt(0),0) + 1);
        for(int i=1;i<n;i++){
            rightMap.put(s.charAt(i),rightMap.getOrDefault(s.charAt(i),0) + 1);
        }
        if(leftMap.size() == rightMap.size())
            count++;
        for(int i=1;i<n-1;i++){
            leftMap.put(s.charAt(i),leftMap.getOrDefault(s.charAt(i),0) + 1);
            rightMap.put(s.charAt(i),rightMap.get(s.charAt(i)) - 1);
            if(rightMap.get(s.charAt(i)) == 0)
                rightMap.remove(s.charAt(i));
            if(leftMap.size() == rightMap.size())
            count++;
        }
        return count;
    }
}