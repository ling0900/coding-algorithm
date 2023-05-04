package leetcode.lh.day0504;

class Solution2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // 初始化
        boolean flag = true;
        for (int m1 = 0; m1 < m; m1 ++) {
            if (obstacleGrid[m1][0] == 0 && flag) {
                dp[m1][0] = 1;
            } else {
                flag = false;
                dp[m1][0] = 0;
            }
            System.out.println("dp[" + m1 + "][" + 0 +"]=" + dp[m1][0]);
        }

        flag = true;

        for (int n1 = 0; n1 < n; n1 ++) {
            if(obstacleGrid[0][n1] == 0 && flag) {
                dp[0][n1] = 1;
            } else {
                flag = false;
                dp[0][n1] = 0;
            }
            System.out.println("dp[" + 0 + "][" + n1 +"]=" + dp[0][n1]);
        }

        // 动态
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                System.out.println("dp[" + i + "][" + j +"]=" + dp[i][j]);
                System.out.println("dp[" + (i - 1) + "][" + j +"]=" + dp[i - 1][j]);
                System.out.println("dp[" + i + "][" + (j - 1) +"]=" + dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0, 0}};
        int i = uniquePathsWithObstacles(test);
        System.out.println(i);
    }
}