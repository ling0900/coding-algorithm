package leetcode.lh.window.lc239;

public class Pow {

    public static void main(String[] args) {
        System.out.println(solve(2, 4));
    }



    public static int solve(int k, int n) {
        int res = 1;
        int t = k;

        while(n != 0) {
            if ((n & 1) != 0) {
                res *= t;
            }
            n >>= 1;
        }
        return res;
    }
}
