class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        List<StringBuffer> li = new ArrayList<>();
        int carry = 0;
        for(int i=n2-1;i>=0;i--){
            StringBuffer inner = new StringBuffer();
            carry = 0;
            for(int j=n1-1;j>=0;j--){
                int mul = (num1.charAt(j) - '0') * (num2.charAt(i) - '0') + carry;
                inner.insert(0,mul % 10);
                carry = mul / 10;
            }
            if(carry > 0){
                inner.insert(0,carry);
            }
            li.add(inner);
        }
        int size = li.size();
        for(int i=0;i<size;i++){
            for(int j=0;j<i;j++){
                li.get(i).append(0);
            }
        }
        System.out.println(li);
        String temp = "";
        for(int i=0;i<size;i++){
            temp = addStrings(li.get(i),temp);
        }
        int zeros = 0;
        for(int i=0;i<temp.length();i++){
            if(temp.charAt(i) == '0')
                zeros++;
            else
                return temp;
        }
        return "0";
    }
    public String addStrings(StringBuffer num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        StringBuffer sb = new StringBuffer();
        int ptr1 = n1 - 1;
        int ptr2 = n2 - 1;
        int carry = 0;
        while(ptr1 >= 0 || ptr2 >= 0 || carry > 0){
            int digit1 = (ptr1 >= 0) ? num1.charAt(ptr1--) - '0' : 0;
            int digit2 = (ptr2 >= 0) ? num2.charAt(ptr2--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            sb.insert(0,(sum % 10));
            carry = sum / 10;
        }
        return sb.toString();
    }
}