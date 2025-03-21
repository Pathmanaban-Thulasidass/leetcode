class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        int suppliesLen = supplies.length;
        Map<String,List<String>> adj = new HashMap<>();
        Map<String,Integer> indegree = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.put(recipes[i],new ArrayList<>());
            indegree.put(recipes[i],ingredients.get(i).size());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<ingredients.get(i).size();j++){
                if(adj.get(ingredients.get(i).get(j)) == null){
                    adj.put(ingredients.get(i).get(j),new ArrayList<>());
                }
                adj.get(ingredients.get(i).get(j)).add(recipes[i]);
            }            
        }
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<suppliesLen;i++){
            queue.add(supplies[i]);
        }
        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(adj.get(cur) != null){
                for(String child : adj.get(cur)){
                    if(indegree.get(child) != null){
                        indegree.put(child,indegree.get(child) - 1);
                        if(indegree.get(child) == 0){
                            ans.add(child);
                            queue.add(child);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
