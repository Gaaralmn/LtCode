/** Climb stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author Qing Wang
 * Tag: DP
 * Follow up: How to realize O(1) space 
 */
public class climbStair {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (i < 3) {
                memo[i] = i;
            } else {
                memo[i] = memo[i - 1] + memo[i - 2];
            }
        }
        return memo[n];
    }
}