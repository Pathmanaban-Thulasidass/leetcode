class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;
        int zeros = 0;
        int canFlower = 0;
        int sum = 0;
        for(int i=0;i<size;i++){
            sum += flowerbed[i];
            if(flowerbed[i] == 1){
                canFlower = zeros / 2;
                if(sum > 1 && zeros % 2 == 0){
                    // between two one's
                    canFlower -= 1;
                }
                n -= canFlower;
                zeros = 0;
            }
            else{
                zeros++;
            }
        }
        canFlower = zeros / 2;
        n -= canFlower;
        if(zeros == size && zeros % 2 != 0){ // all zeros with odd size
            n -= 1;
        }
        System.out.println(n);
        return n <= 0;
    }
}