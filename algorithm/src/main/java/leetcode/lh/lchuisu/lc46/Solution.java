package leetcode.lh.lchuisu.lc46;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) {
            return res;
        }
        combine(0, nums, res, new ArrayList<>(), new HashSet<>());
        return res;
    }

    public void combine(int begin, int[] nums, List<List<Integer>> res, List<Integer> path, HashSet<Integer> set) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        } else {
            for(int i = begin; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    continue;
                }
                path.add(nums[i]);set.add(nums[i]);
                combine(0, nums, res, path, set);
                path.remove(path.size() - 1);set.remove(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }


}
