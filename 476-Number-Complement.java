class Solution {
    public int findComplement(int num) {
        if(num==0)
            return 1;
        int result=0;
        int i=0;
        while(num>0){
            int reminder=num%2 ^ 1;
            result+= reminder*Math.pow(2,i++);
            num/=2;
        }
        return result;
    }
}
