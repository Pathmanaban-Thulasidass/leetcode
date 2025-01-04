class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        int n1 = word1.length();
        int n2 = word2.length();
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < n1 && ptr2 < n2){
            int first = word1.charAt(ptr1);
            int second = word2.charAt(ptr2);
            if(first > second){
                sb.append(word1.charAt(ptr1++));
            }
            else if(first < second){
                sb.append(word2.charAt(ptr2++));
            }
            else{
                if(word1.substring(ptr1).compareTo(word2.substring(ptr2)) > 0){
                    sb.append(word1.charAt(ptr1++));
                } else {
                    sb.append(word2.charAt(ptr2++));
                }
            }
        }
        while(ptr1 < n1){
            sb.append(word1.charAt(ptr1++));
        }
        while(ptr2 < n2){
            sb.append(word2.charAt(ptr2++));
        }
        return sb.toString();
    }
}