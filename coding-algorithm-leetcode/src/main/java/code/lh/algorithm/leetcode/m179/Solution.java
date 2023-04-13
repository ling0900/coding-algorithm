package code.lh.algorithm.leetcode.m179;

import java.util.Arrays;

public class Solution {
    public static String largestNumber(String[] nums) {

        if (nums == null || nums.length == 0) {
            return "";
        }


        String[] strings = new String[nums.length];

        for (int i = 0; i < nums.length; i ++) {
            strings[i] = nums[i] + "";
        }

        Arrays.sort(strings);

        StringBuilder re = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i --) {
            re.append(strings[i]);
        }

        return re.toString();
    }


    public static void main(String[] args) {
        String[] ss = new String[]{"30","3","5", "9", "34"};

        String s = largestNumber(ss);
        System.out.println(s);


    }
}
