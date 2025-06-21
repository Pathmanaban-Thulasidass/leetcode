class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int n1 = a.length();
        int n2 = b.length();
        int ptr1 = n1 - 1;
        int ptr2 = n2 - 1;
        int carry = 0;
        while(ptr1 >= 0 && ptr2 >= 0){
            if(carry == 0){
                if(a.charAt(ptr1) == '1' && b.charAt(ptr2) == '1'){
                    carry = 1;
                    sb.append("0");
                }
                else{
                    int temp = (a.charAt(ptr1) - '0') + (b.charAt(ptr2) - '0');
                    sb.append(temp + "");
                }
            }
            else{
                if(a.charAt(ptr1) == '1' && b.charAt(ptr2) == '1'){
                    carry = 1;
                    sb.append("1");
                }
                else{
                    int temp = (a.charAt(ptr1) - '0') + (b.charAt(ptr2) - '0') + carry;
                    if(temp >= 2){
                        carry = 1;
                        sb.append("0");
                    }
                    else{
                        carry = 0;
                        sb.append(temp + "");
                    }
                }
            }
            ptr1--;
            ptr2--;
        }
        while(ptr1 >= 0){
            if(carry == 0){
                sb.append(a.charAt(ptr1));
            }
            else{
                if(a.charAt(ptr1) == '1'){
                    carry = 1;
                    sb.append("0");
                }
                else{
                    carry = 0;
                    sb.append("1");
                }
            }
            ptr1--;
        }
        while(ptr2 >= 0){
            if(carry == 0){
                sb.append(b.charAt(ptr2));
            }
            else{
                if(b.charAt(ptr2) == '1'){
                    carry = 1;
                    sb.append("0");
                }
                else{
                    carry = 0;
                    sb.append("1");
                }
            }
            ptr2--;
        }
        if(carry > 0){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}