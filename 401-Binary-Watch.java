class Solution {
    int mapArr[] = {8,4,2,1,32,16,8,4,2,1};
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        generateSeq(0,turnedOn,0,new boolean[10],ans);
        return ans;
    }
    public void generateSeq(int index,int turnedOn,int lightCount,boolean[] arr,List<String> ans){
        if(turnedOn == lightCount){
            convertor(arr,ans);
            return;
        }
        if(index == 10){
            return;
        }
        //take
        arr[index] = true;
        generateSeq(index + 1,turnedOn,lightCount + 1,arr,ans);
        //don't take
        arr[index] = false;
        generateSeq(index + 1,turnedOn,lightCount,arr,ans);
    }
    public void convertor(boolean[] arr,List<String> ans){
        int hr = 0;
        int min = 0;
        String s = \\;
        for(int i=0;i<4;i++){
            if(arr[i]){
                hr += mapArr[i];
            }
        }
        for(int i=4;i<10;i++){
            if(arr[i]){
                min += mapArr[i];
            }
        }
        if(hr > 11 || min >= 60)
            return;
        if(min > 9)
            s = hr + \:\ + min;
        else
            s = hr + \:0\ + min; 
        ans.add(s);
    }
}