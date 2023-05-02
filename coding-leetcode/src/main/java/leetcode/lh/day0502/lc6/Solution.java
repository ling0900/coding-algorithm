package leetcode.lh.day0502.lc6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Solution.
 * N 变换
 */

class Solution {
    public static String convert(String s, int numRows) {


        if (s == null || s.length() < 1 || numRows < 1) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> strs = new ArrayList<>();

        for (int i = 0; i < numRows; i ++) {
            strs.add(new StringBuilder());
        }

        // 定义一个标志，代表行索引开始减小
        boolean flag = false;

        // 索引
        int index = 0;

        for (int i = 0; i < s.length(); i ++) {

            strs.get(index).append(s.charAt(i));

            // 更新索引
            if (flag) { // -1
                index -= 1;
                if (index == 0) {
                    flag = false;
                }
            } else { // +1
                index += 1;
                if (index == numRows - 1) {
                    flag = true;
                }
            }
        }

        for (int i = 1; i < numRows; i ++) {
            strs.get(0).append(strs.get(i));
        }

        return strs.get(0).toString();
    }


    public static void main(String[] args) {
        String s = convert("PAYPALISHIRING", 4);
        System.out.println(s);

    }
}
