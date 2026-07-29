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
        int l = 1 , r = n;

        while(l <= r){
            int guess_No = l + ( r - l) / 2;
            int num = guess(guess_No);
            if(num == 0) return guess_No;
            else if(num == -1) r = guess_No - 1;
            else l = guess_No + 1;
        }
        return -1;
    }
}
