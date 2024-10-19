class Solution {
    public char findKthBit(int n, int k) {
        StringBuffer sb = new StringBuffer("0");
        for(int i=1;i<n;i++){
            StringBuffer reverseAndInvertSB = reverseAndInvert(new StringBuffer(sb));
            sb = sb.append('1').append(reverseAndInvertSB);
        }
        return sb.charAt(k-1);
    }
    public StringBuffer reverseAndInvert(StringBuffer sb){
        int left = 0;
        int right = sb.length() - 1;
        while(left <= right){
            if(sb.charAt(left) == sb.charAt(right)){
                if(sb.charAt(left) == '1'){
                    sb.setCharAt(left,'0');
                    sb.setCharAt(right,'0');
                }
                else{//sb.charAt(left) == '0'
                    sb.setCharAt(left,'1');
                    sb.setCharAt(right,'1');
                }
            }
            left++;
            right--;
        }
        return sb;
    }
}