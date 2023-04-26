package code.lh.algorithm.leetcode.m128;

import java.util.Arrays;
import java.util.Map;

public class Solution {

    public static int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        if (nums.length == 2) {
            int i = nums[0] - nums[1];
            int abs = Math.abs(i);
            if (abs != 1) {
                return 1;
            }
            return 2;
        }

        // 有序了
        Arrays.sort(nums);

        int res = 1;
        int temp = 1;

        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] - nums[i - 1] == 1 || nums[i] - nums[i - 1] == 0) {
                temp += nums[i] - nums[i -1];
                if (i != nums.length - 1) {
                    continue;
                }
            }
            res = Math.max(temp, res);
            temp = 1;
        }

        return res;
    }



    public static void main(String[] args){

        int[] test = new int[]{0,0,-1};
        int i = longestConsecutive(test);
        System.out.println(i);
    }
}
