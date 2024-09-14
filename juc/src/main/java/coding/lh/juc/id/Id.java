package coding.lh.juc.id;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Id {
    public static void main(String[] args) {

        List<String> dateList = new ArrayList<>();

        // 设置日期格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");

        // 设置开始和结束年份
        int startYear = 2024;
        int endYear = 2034;

        // 遍历年份和月份
        for (int year = startYear; year <= endYear; year++) {
            for (int month = 1; month <= 12; month++) {
                // 创建每月的第一天
                LocalDate date = LocalDate.of(year, month, 1);
                // 格式化日期并添加到列表
                dateList.add(date.format(formatter));
            }
        }

        // J M1 K M2 I D1 M D2

        // 0 0  0  1 0  0  0  1




    }
}
