package leetcode.lh.day0503.lc70;

/**
 * The type Solution.
 *
 */
class Solution {
    /**
     * Climb stairs int.
     *
     * @param n the n
     * @return the int
     */
    /*public int climbStairs(int n) {

        if (n <= 0) return 0;

        int dp[] = new int[n + 2];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }*/

    public int climbStairs(int n) {

        if (n <= 2) return n;

        int m = 1;
        int p = 1;
        int r = 1;

        for (int i = 3; i <=n; i++) {

            m = p;
            p = r;
            r = m + p;
        }

        return r;
    }
}