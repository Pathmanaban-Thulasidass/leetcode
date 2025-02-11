class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int size = pairs.size();
        if(size == 0)
            return s;
        DisJointSet djs = new DisJointSet(n,s);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<size;i++){
            djs.union(pairs.get(i).get(0),pairs.get(i).get(1));
        }
        for(int i=0;i<n;i++){
            djs.find(i);
        }
        for(int i=0;i<n;i++){
            int tempParent = djs.parent[i];
            if(djs.map.get(tempParent) == null){
                sb.append(s.charAt(i));
            }
            else{
                sb.append(djs.map.get(tempParent).poll());
            }
        }
        return sb.toString();
    }
}
class DisJointSet{
    int parent[];
    int size[];
    String s;
    Map<Integer,PriorityQueue<Character>> map = new HashMap<>();
    public DisJointSet(int n,String s){
        parent = new int[n];
        size = new int[n];
        this.s = s;
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int u){
        if(parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }
    public boolean union(int u,int v){
        int ulp_u = find(u);
        int ulp_v = find(v);
        if(ulp_u == ulp_v)
            return false;
        if(size[ulp_u] >= size[ulp_v]){
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v]; 
            if(map.get(ulp_u) == null){
                PriorityQueue<Character> pq = new PriorityQueue<>();
                pq.add(s.charAt(ulp_u));
                pq.add(s.charAt(ulp_v));
                map.put(ulp_u,pq);
            }
            else{
                if(map.get(ulp_v) == null){
                    map.get(ulp_u).add(s.charAt(ulp_v));
                }
                else{
                    map.get(ulp_u).addAll(map.get(ulp_v));
                    map.remove(ulp_v);
                }
            }
        }
        else{
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
            if(map.get(ulp_v) == null){
                PriorityQueue<Character> pq = new PriorityQueue<>();
                pq.add(s.charAt(ulp_v));
                pq.add(s.charAt(ulp_u));
                map.put(ulp_v,pq);
            }
            else{
                if(map.get(ulp_u) == null){
                    map.get(ulp_v).add(s.charAt(ulp_u));
                }
                else{
                    map.get(ulp_v).addAll(map.get(ulp_u));
                    map.remove(ulp_u);
                }
            }
        }
        return true;
    }
}