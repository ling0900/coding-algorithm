package leetcode.lh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterString {
    public static String filterString(String inputStr) {
        // 使用正则表达式找到纯英文和纯数字部分
        Pattern alphaPattern = Pattern.compile("\\b[a-zA-Z]+\\b");
        Matcher alphaMatcher = alphaPattern.matcher(inputStr);
        StringBuffer alphaOnly = new StringBuffer();

        while (alphaMatcher.find()) {
            alphaOnly.append(alphaMatcher.group()).append(" ");
        }

        Pattern numericPattern = Pattern.compile("\\b\\d+\\b");
        Matcher numericMatcher = numericPattern.matcher(inputStr);
        StringBuffer numericOnly = new StringBuffer();

        while (numericMatcher.find()) {
            numericOnly.append(numericMatcher.group()).append(" ");
        }

        // 合并结果为新字符串
        String resultStr = alphaOnly.toString().trim() + " " + numericOnly.toString().trim();
        return resultStr;
    }

    public static void main(String[] args) {
        // 示例输入
        String inputString = "not a* found kk3";

        // 处理字符串
        String outputString = filterString(inputString);

        // 打印结果
        System.out.println(outputString);
    }
}
