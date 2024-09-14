package leetcode.lh.day0502.lc300;

import org.junit.Test;

import java.util.Map;

class Solution {
    public static int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }


        int[] dp = new int[nums.length];

        int res = 1;
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {


            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(dp[i], res);

        }
        return res;
    }



}
