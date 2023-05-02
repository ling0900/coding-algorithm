package leetcode.lh.day0502.lc59;

public class Solution {
    /*public static int fib(int n) {
        if (n < 1) return 0;

        if (n == 1) return 1;

        return fib(n - 1) + fib(n - 2);
    }*/

    /*public static int fib(int n) {

        int[] dp = new int[40];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < 40; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }

        return dp[n];
    }*/


    public static int fib(int n) {
        if (n < 2) {
            return n;
        }

        int p = 0, q = 0, r = 1;

        for (int i = 2; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
