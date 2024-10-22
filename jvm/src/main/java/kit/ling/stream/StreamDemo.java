package kit.ling.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // 创建一个字符串数组
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};

        // 创建数组对应的流
        Stream<String> nameStream = Arrays.stream(names);

        // 遍历流中的元素，并打印到控制台
        nameStream.forEach(System.out::println);

        System.out.println("----------------------------------------");

        // 将names转成list
        List<String> nameList = Arrays.asList(names);
        // 遍历list中的元素，并打印到控制台
        nameList.forEach(System.out::println);

        System.out.println("----------------------------------------");

        Stream.of(names).forEach(System.out::println);

        System.out.println("----------------------------------------");

        // 通过迭代器，生成并打印1-10这些数字
        Stream.iterate(1, n -> n + 1).limit(10).forEach(System.out::println);

        System.out.println("----------------------------------------");
        // 通过generate 生成并打印10个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
