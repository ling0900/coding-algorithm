package leetcode.lh.window.lc239;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 头部是最大值
        LinkedList<Integer> maxWindow = new LinkedList<>();

        int[] res = new int[nums.length + 1 - k];
        int resIndex = 0;
        int R = 0;

        if (k == 1) return nums;

        for (; R < k; R++) {
            while (!maxWindow.isEmpty() && nums[maxWindow.peekLast()] <= nums[R]) {
                maxWindow.pollLast();
            }
            maxWindow.addLast(R);
        }

        res[resIndex++] = nums[maxWindow.getFirst()];

        for (int L = 0; R < nums.length; R++, L++) {

            while (!maxWindow.isEmpty() && nums[maxWindow.peekLast()] <= nums[R]) {
                maxWindow.pollLast();
            }
            maxWindow.addLast(R);

            if(maxWindow.getFirst() == L) {
                maxWindow.removeFirst();
            }

            res[resIndex++] = nums[maxWindow.getFirst()];

        }
        return res;
    }
}