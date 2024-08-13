package code.lh.base.jdkversion;

public class Intern2 {
    public static void main(String[] args) {
//        String s1 = new String("a");
//        s1.intern();
//        String s2 = "a";
//        System.out.println(s1 == s2); // false


//        String s3 = new String("a2") + new String("a2");
//        s3.intern();
//        String s4 = "a2a2";
//        System.out.println(s3 == s4);


//        String s0 = "m1m2";
//        String s1 = new String("m1m2");
//        String s1_0 = s1.intern();
//        System.out.println(s0 == s1);
//        System.out.println(s0 == s1_0);
//        System.out.println(s1 == s1_0);


//        String s = new String("e2");
//        String s1 = "e2";
//        System.out.println(s == s1);

        String s1 = "e2";
        String s = new String("e2");
        System.out.println(s == s1);// == 比较的是地址
        System.out.println(s.equals(s1));
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(s1));

    }
}
