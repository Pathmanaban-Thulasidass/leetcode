class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int window1Sum = 0;
        int window2Sum = 0;
        int slider1 = k - 1;
        int slider2 = n;
        int max = 0;
        for(int i=0;i<k;i++){
            window1Sum += cardPoints[i];
        }
        while(slider1 >= 0){
            max = Math.max(max,(window1Sum + window2Sum));
            window1Sum -= cardPoints[slider1];
            slider1--;
            slider2--;
            window2Sum += cardPoints[slider2];
        }
        max = Math.max(max,(window1Sum + window2Sum));
        return max;
    }
}