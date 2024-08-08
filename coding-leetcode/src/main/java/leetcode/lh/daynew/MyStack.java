package leetcode.lh.daynew;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 *
 *
 */
class MyStack {
    Queue<Integer> q1, q2;

    public MyStack() {
        // 一般jdk的确用的链表实现队列
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (q2.isEmpty()) {
            q1.add(x);
        }
    }

    public int pop() {
        if (q2.isEmpty() && !q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.poll());
            }
        }
        Queue<Integer> qt = new LinkedList<>();
        Integer res = q1.poll();
        qt = q1;
        q1 = q2;
        q2 = qt;
        return res;
    }

    public int top() {
        if (q2.isEmpty() && !q1.isEmpty()) {
            while (q1.size() > 1) {
                q2.add(q1.poll());
            }
        }
        Queue<Integer> qt = new LinkedList<>();
        Integer res = q1.peek();
        q2.add(q1.poll());
        qt = q1;
        q1 = q2;
        q2 = qt;
        return res;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}