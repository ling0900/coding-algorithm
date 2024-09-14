package leetcode.lh.lc3174;

/**
 * 给你一个字符串 s 。
 *
 * 你的任务是重复以下操作删除 所有 数字字符：
 * 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
 * 请你返回删除所有数字字符以后剩下的字符串。
 * 示例 1：
 * 输入：s = "abc"
 * 输出："abc"
 * 解释：
 * 字符串中没有数字。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ab1";
        String res = solution.removeDigits(s);
        System.out.println(res);
    }

    public String removeDigits(String s) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
