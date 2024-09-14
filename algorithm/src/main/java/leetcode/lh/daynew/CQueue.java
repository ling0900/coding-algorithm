package leetcode.lh.daynew;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/submissions/553559652/
 * 读者来到图书馆排队借还书，图书管理员使用两个书车来完成整理借还书的任务。
 * 书车中的书从下往上叠加存放，图书管理员每次只能拿取书车顶部的书。排队的读者会有两种操作：
 *
 * push(bookID)：把借阅的书籍还到图书馆。
 * pop()：从图书馆中借出书籍。
 * 为了保持图书的顺序，图书管理员每次取出供读者借阅的书籍是 最早 归还到图书馆的书籍。
 * 你需要返回 每次读者借出书的值 。
 *
 * 如果没有归还的书可以取出，返回 -1 。
 */
public class CQueue {
    // 用栈实现队列，定义两个车
    Stack<Integer> s1, s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        //直接放到第一个车上
        s1.add(value);
    }

    public int deleteHead() {

        if (!s2.isEmpty()) {
            return s2.pop();
        }

        //每次取的时候，把第一个车从上往下放到第二个车，然后取出来第二个车的顶部的
        if (s1.isEmpty() && s2.isEmpty()) {
            return -1;
        }

        if (!s1.isEmpty() && s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.add(s1.pop());
            }
            return s2.pop();
        }

        return -1;
    }
}
