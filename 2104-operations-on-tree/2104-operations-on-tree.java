class LockingTree {

    int parent[];
    int lockUser[];
    List<List<Integer>> adj = new ArrayList<>();
    public LockingTree(int[] parent) {
        this.parent = parent;
        int n = parent.length;
        lockUser = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            int v = parent[i];
            adj.get(v).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(lockUser[num] != 0)
            return false;
        lockUser[num] = user;   
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(lockUser[num] == user){
            lockUser[num] = 0;
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        if(lockUser[num] != 0)  
            return false;
        if(!checkForAncestors(num) || !checkForDescendent(num))
            return false;

        unlockAllDescents(num);
        
        lockUser[num] = user;
        return true;
    }

    public boolean checkForAncestors(int num){
        int temp = num;
        while(parent[temp] != -1){
            temp = parent[temp];
            if(lockUser[temp] != 0)
                return false;
        }
        return true;
    }

    public boolean checkForDescendent(int num){
        if(lockUser[num] != 0)
            return true;
        for(int child : adj.get(num)){
            if(checkForDescendent(child))
                return true;
        }
        return false;
    }

    public void unlockAllDescents(int num){
        lockUser[num] = 0;
        for(int child : adj.get(num)){
            unlockAllDescents(child);
        }
    }

}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */