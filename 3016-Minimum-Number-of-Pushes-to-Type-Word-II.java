class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = word.length();
        int noOfClicked = 0;
        for(int i=0;i<n;i++){
            map.put(word.charAt(i),map.getOrDefault(word.charAt(i),0) + 1);
        }
        List<Integer> arr = new ArrayList<>();
        int j = 0;
        int mul = 1;
        for(char key : map.keySet()){
            arr.add(map.get(key));
        }
        Collections.sort(arr, Collections.reverseOrder());
        for(int i=0;i<arr.size();i++){
            noOfClicked += arr.get(i) * mul;
            if((i+1)%8==0){
                mul++;
            }
        }
        return noOfClicked;
    }
}