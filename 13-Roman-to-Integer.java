class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        // List<Character> list = Arrays.asList('I','V','X','L','C','D','M');
        int i;
        for(i=0; i<s.length() - 1 ; i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                ans += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i++;
            }
            else{
                ans += map.get(s.charAt(i));
            }
        }
        if(i < s.length())
            ans += map.get(s.charAt(i));
        return ans;
    }
}