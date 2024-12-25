class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> noLost = new ArrayList<Integer>();
        List<Integer> oneLost = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap();
        for (int[] match: matches) {
            map.put(match[0], map.getOrDefault(match[0], 0));
            map.put(match[1], map.getOrDefault(match[1], 0) + 1);
        }
        
        for (int player: map.keySet()) {
            if (map.get(player) == 0) {
                noLost.add(player);
            } else if (map.get(player) == 1) {
                oneLost.add(player);
            }
        }
        
        Collections.sort(noLost);
        Collections.sort(oneLost);

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(noLost);
        ans.add(oneLost);
        return ans;
    }
}