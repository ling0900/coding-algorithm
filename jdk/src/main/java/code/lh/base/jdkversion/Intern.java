package kit.ling.jdkversion;

public class Intern {
    public static void main(String[] args) {
        String s1 = new String("a");
        String s1_intern = s1.intern();
        String s2 = "a";

        System.out.println(s1 == s2); // false
        System.out.println(s1_intern == s2);

        String s3 = new String("a") + new String("a");
        s3.intern( );
        String s4 = "aa";

        System.out.println(s3 == s4);// true

    }
}
