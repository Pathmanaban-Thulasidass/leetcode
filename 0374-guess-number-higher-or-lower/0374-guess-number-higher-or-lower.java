/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long low = 1;
        long high = (long)n;
        while(low <= high){
            int mid = (int)((low + high) / 2);
            int move = guess(mid);
            if(move == 0)
                return mid;
            else if(move == -1){
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return -1;
    }
}