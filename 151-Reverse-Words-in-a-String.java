class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(\\\\\s+\);
        StringBuffer sb = new StringBuffer();
        for(int i=arr.length-1;i>=0;i--){
            sb.append(arr[i].trim());
            if(i!=0){
                sb.append(\ \);
            }
        }
        return sb.toString().trim();
    }
}