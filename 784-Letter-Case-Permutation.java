class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        int[] indexArr = new int[12];
        int size = s.length();
        int n = 0;
        for(int i=0;i<size;i++){
            if(Character.isLetter(s.charAt(i))){
                indexArr[n++] = i;
            }
        }
        if(n == 0)
            return Arrays.asList(s);
        System.out.println(n);
        generateSeq(0,n,new StringBuffer(s),new boolean[n],ans,indexArr);
        return ans;
    }
    public void generateSeq(int index,int n,StringBuffer s,boolean []arr,List<String> ans,int[] indexArr){
        if(index == n){
            convertor(n,s,arr,ans,indexArr);
            return;
        }
        arr[index] = true;
        generateSeq(index + 1,n,s,arr,ans,indexArr);

        arr[index] = false;
        generateSeq(index + 1,n,s,arr,ans,indexArr);

    }
    public void convertor(int n,StringBuffer s,boolean []arr,List<String> ans,int[] indexArr){
        for(int i=0;i<n;i++){
            if(!arr[i]){
                //lowercase
                if(Character.isUpperCase(s.charAt(indexArr[i]))){
                    s.setCharAt(indexArr[i],Character.toLowerCase(s.charAt(indexArr[i])));
                }
            }
            else{
                //uppercase
                if(Character.isLowerCase(s.charAt(indexArr[i]))){
                    s.setCharAt(indexArr[i],Character.toUpperCase(s.charAt(indexArr[i])));
                }
            }
        }
        ans.add(s.toString());
    }

}