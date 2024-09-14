package leetcode.lh.window.lc239;

public class Pow {

    public static void main(String[] args) {
        System.out.println(solve(2, 4));
    }



    public static double solve(int k, int n) {
        double res = 1D;
        double t = k;

        boolean b = false;
        if (n > 0) b = true;

        n = Math.abs(n);

        while(n != 0) {
            if ((n & 1) != 0) {
                res *= t;
            }
            n >>= 1;
        }

        if (b) {
            return res;
        } else {
            return res;
        }

    }
}
