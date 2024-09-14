package kit.ling.jdkversion;

import java.util.Arrays;
import java.util.List;


public class LambdaTest {
    public static void main(String... args) {
        List<String> strList = Arrays.asList("1", "2", "3");

        // 写法1
        strList.forEach(s -> {
            System.out.println(s);
        });

        // 写法2
        strList.forEach(s -> System.out.println(s));
    }
}
