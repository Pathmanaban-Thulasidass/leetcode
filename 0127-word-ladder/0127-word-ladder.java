class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        int size = wordList.size();
        if(!wordList.contains(endWord))
            return 0;
        boolean visited[] = new boolean[size];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<size;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                int change = changes(wordList.get(i),wordList.get(j),n);
                if(change == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<size;i++){
            if(changes(beginWord,wordList.get(i),n) == 1){
                if(wordList.get(i).equals(endWord)){
                    // System.out.println("...");
                    return 2;
                }
                queue.add(new int[]{i,2});
                visited[i] = true;
            }
        }
        if(queue.isEmpty())
            return 0;
        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int curIndex = cur[0];
            int curDis = cur[1];
            for(int child : adj.get(curIndex)){
                if(wordList.get(child).equals(endWord))
                    return curDis + 1;
                if(!visited[child]){
                    queue.add(new int[]{child,curDis + 1});
                    visited[child] = true;
                }
            }
        }
        return 0;
    }
    public int changes(String s1,String s2,int n){
        int count = 0;
        for(int i=0;i<n;i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        }
        return count;
    }
}