class Solution {
    public int appendCharacters(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int ptr1 = 0;
        int ptr2 = 0;
        int temp1 = 0;
        while(ptr1 < n1 && ptr2 < n2){
            if(s.charAt(ptr1) == t.charAt(ptr2)){
                temp1 = ptr1;
                ptr2++;
            }
            ptr1++;
        }
        ptr1 = temp1 + 1;
        while(ptr1 < n1 && ptr2 < n2){
            if(s.charAt(ptr1) == t.charAt(ptr2)){
                ptr2++;
            }
            ptr1++;
        }
        return n2 - ptr2;
    }
}