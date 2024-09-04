class Solution {
    boolean isNorth = true;
    boolean isSouth = false;
    boolean isEast = false;
    boolean isWest = false;
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        int max = Integer.MIN_VALUE;
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        for(int command : commands){
            if(command == -1){
                turnRight();
            }
            else if(command == -2){
                turnLeft();
            }
            else{
                if(isNorth){
                    int temp = y;
                    for(int i=temp+1;i<=temp+command;i++){
                        if(isObstacle(new int[]{x,i},obstacleSet))
                            break;
                        y++;
                    }
                }
                else if(isSouth){
                    int temp = y;
                    for(int i=temp-1;i>=temp-command;i--){
                        if(isObstacle(new int[]{x,i},obstacleSet))
                            break;
                        y--;
                    }
                }
                else if(isEast){
                    int temp = x;
                    for(int i=temp+1;i<=temp+command;i++){
                        if(isObstacle(new int[]{i,y},obstacleSet))
                            break;
                        x++;
                    }
                }
                else{
                    int temp = x;
                    for(int i=temp-1;i>=temp-command;i--){
                        if(isObstacle(new int[]{i,y},obstacleSet))
                            break;
                        x--;
                    }
                }
            }
            if(max < (x*x) + (y*y)){
                max = (x*x) + (y*y);
            }
        }
        return max;
    }
    public void turnRight(){
        if(isNorth){
            isNorth = false;
            isEast = true;
        }
        else if(isSouth){
            isSouth = false;
            isWest = true;
        }
        else if(isEast){
            isEast = false;
            isSouth = true;
        }
        else{
            isWest = false;
            isNorth = true;
        }
    }
    public void turnLeft(){
        if(isNorth){
            isNorth = false;
            isWest = true;
        }
        else if(isSouth){
            isSouth = false;
            isEast = true;
        }
        else if(isEast){
            isEast = false;
            isNorth = true;
        }
        else{
            isWest = false;
            isSouth = true;
        }
    }
    public boolean isObstacle(int []obstacle,Set<String> obstacleSet){
        return obstacleSet.contains(obstacle[0] + "," + obstacle[1]);
    }
}