package leetcode.lh.nonday.day02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Solution.
 *
 */
public class Solution {
    /**
     * Exist boolean.
     *
     * @param board the board
     * @param word  the word
     * @return the boolean
     */
    public static boolean exist(char[][] board, String word) {

        // 定义这个标记
        boolean[][] walk = new boolean[board.length][board[0].length];

        // 定义方向
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backExist(walk, i, j, board, word, 0, directions)) {
                    return true;
                }
            }
        }
        return false;
    }


    private static boolean backExist(boolean[][] walk, int m, int n, char[][] board, String word, int searchIndex, int[][] directions) {

        if (board[m][n] != word.charAt(searchIndex)) {
            return false;
        } else {
            walk[m][n] = true;
        }

        // 这里已经表明 字符 相等了，如果长度满足，则说明遍历找到了，结束。
        if (searchIndex == word.length() - 1) {
            return true;
        }

        boolean resultFlag = false;

        for (int[] direction : directions) {// 搜索四个方向都搞一遍
            int iNew = direction[0] + m;
            int jNew = direction[1] + n;
            if (iNew >= 0 && iNew < board.length && jNew >= 0 && jNew < board[0].length) {// 首先保证不越界
                if (! walk[iNew][jNew] && backExist(walk, iNew, jNew, board, word, searchIndex + 1, directions)) {
                    resultFlag = true;
                    break;
                }
            }
        }

        // 如果所有方向遍历后依旧没有答案，说明上个为止是有问题的，需要复位，然后让外部的for去调用其他的。
        walk[m][n] = false;

        return resultFlag;
    }

    public static void main(String[] args) {
        char[][] test = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";

        boolean exist = exist(test, word);
        System.out.println(exist);
    }
}
