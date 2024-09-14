package leetcode.lh.lc3176;

/**
 * 给你一个整数数组 nums 和一个 非负 整数 k 。
 * 如果一个整数序列 seq 满足在下标范围 [0, seq.length - 2] 中
 * 最多只有 k 个下标 i 满足 seq[i] != seq[i + 1] ，
 * 那么我们称这个整数序列为 好 序列。
 * 请你返回 nums 中 好子序列
 *  的最长长度。
 *  [2 2 2 1 1 2 3 4]
 */
public class Solution {
    public int maximumLength(int[] nums, int k) {
        int res = 0;
        int left, right;
        for (int i = 0; i < nums.length; i++) {
            left = i;
            right = i + 1;
            int count = 0;
            while (right < nums.length - 1) {
                if (nums[left] != nums[right]) {
                    count++;
                    left++;
                    right++;
                } else {
                    if (right - left + 1 <= k) {
                        count++;
                        right++;
                    } else {
                        break;
                    }
                }
            }
            res += count;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 2};
        int k = 2;
        int res = solution.maximumLength(nums, k);
        System.out.println(res);
    }
}
