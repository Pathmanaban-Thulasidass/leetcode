class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int collisions = 0;
        int left = 0;
        int right = n - 1;
        while(left <= right && directions.charAt(left) == 'L')
            left++;
        while(right >= left && directions.charAt(right) == 'R')
            right--;
        for(int i=left;i<=right;i++){
            char ch = directions.charAt(i);
            if(ch != 'S')
                collisions++;
        }
        return collisions;
    }
}