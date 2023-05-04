package leetcode.lh.day0504;

class Solution {
    public static int uniquePaths(int m, int n) {


        if (m == 0 || n == 0) {
            return 1;
        }

        // 从0,0为止到m,n位置一共有的路径
        // 分析可以得到：dp[m][n] 可以由 dp[m - 1][n] 或者 dp[m][n - 1]推导而来
        int[][] dp = new int[m + 1][n + 1];

        // 初始化
        for (int m1 = 0; m1 < m; m1 ++) {
            dp[m1][0] = 1;
        }

        for (int n1 = 0; n1 < n; n1 ++) {
            dp[0][n1] = 1;
        }

        // 动态
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int i = uniquePaths(3 , 7);
        System.out.println(i);
    }
}