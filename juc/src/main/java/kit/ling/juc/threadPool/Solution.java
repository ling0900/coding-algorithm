package kit.ling.juc.threadPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static int compareVersion(String version1, String version2) {

        String[] versionStr1 = version1.split("\\.");
        String[] versionStr2 = version2.split("\\.");

        int m = 0, n = 0;

        for(int i = 0; i < versionStr1.length || i < versionStr2.length; i ++) {
            if (i < versionStr1.length) {
                m = Integer.parseInt(versionStr1[i]);
            } else {
                m = 0;
            }
            if (i < versionStr2.length) {
                n = Integer.parseInt(versionStr2[i]);
            } else {
                n = 0;
            }

            if (m > n) {
                return 1;
            }

            if (m < n) {
                return -1;
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1.0.1";
        String v2 = "1";
        int i = compareVersion(v1, v2);
        System.out.println(i);
    }
}
