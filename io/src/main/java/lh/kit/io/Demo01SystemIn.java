package lh.kit.io;

import java.io.IOException;

/**
 *
 */
public class Demo01SystemIn {
    public static void main(String[] args) throws IOException {
        int a = System.in.read();
        System.out.println(a);
        char c = 'a';
        char c2 = '汉';
        System.out.println((int) c);
        System.out.println((int) c2);
    }
}

