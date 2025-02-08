class NumberContainers {

    Map<Integer,Integer> array;
    Map<Integer,TreeSet<Integer>> indexMap;
    public NumberContainers() {
        array = new HashMap<>();
        indexMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(array.get(index) == null){
            array.put(index,number);
        }
        else{
            int preValue = array.get(index);
            if(preValue != number){
                TreeSet set = indexMap.get(preValue);
                set.remove(index);
                if(set.size() == 0)
                    indexMap.remove(preValue);
                array.put(index,number);
            }
        }
        if(indexMap.get(number) == null){
            TreeSet set = new TreeSet<>();
            set.add(index);
            indexMap.put(number,set);
        }
        else{
            TreeSet set = indexMap.get(number);
            set.add(index);
            indexMap.put(number,set);
        }
    }
    
    public int find(int number) {
       return indexMap.get(number) == null ? -1 : indexMap.get(number).getFirst();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */