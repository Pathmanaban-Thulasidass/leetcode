class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> monoSt = new Stack<>();
        int n = asteroids.length;
        int tempSize = 0;
        boolean isNegEleWinner = false;
        int winner = 0;
        for(int i=0;i<n;i++){
            if(asteroids[i] < 0){
                isNegEleWinner = true;
                while(!monoSt.isEmpty()){
                    if(monoSt.peek() < 0){
                        isNegEleWinner = true;
                        break;
                    }
                    if((asteroids[i] * -1) >= monoSt.peek()){
                        if((asteroids[i] * -1) == monoSt.peek()){
                            isNegEleWinner = false;
                            monoSt.pop();
                            break;
                        }
                        else{
                            isNegEleWinner = true;
                            monoSt.pop();
                        }
                    }
                    else{
                        isNegEleWinner = false;
                        break;
                    }
                }
                if(isNegEleWinner)
                    monoSt.push(asteroids[i]);
            }
            else
                monoSt.push(asteroids[i]);
        }
        int ans[] = new int[monoSt.size()];
        for(int i=monoSt.size()-1;i>=0;i--){
            ans[i] = monoSt.peek();
            monoSt.pop();
        } 
        return ans;
    }
}