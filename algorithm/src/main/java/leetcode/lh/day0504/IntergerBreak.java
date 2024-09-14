package leetcode.lh.day0504;

public class IntergerBreak {
    public static int integerBreak(int n) {

        int[] res = new int[n + 1];

        int temp = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j ++) {// 拆分成 j i-j
//               temp = Math.max(Math.max((i - j) * j, j * res[i - j]), res[i]);
               temp = Math.max((i - j) * j, j * res[i - j]);
            }
            res[i] = Math.max(temp, res[i]);
        }

        return res[n];
    }


    public static void main(String[] args) {
        int i = integerBreak(10);
        System.out.println(i);
    }
}
