package leetcode.lh.daynew;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 利用双端队列实现最小栈
 */
public class MinStack {

    Deque<Integer> dFull, dMin;

    public MinStack() {
        dFull = new LinkedList<>();
        dMin = new LinkedList<>();
    }

    public void push(int val) {
        dFull.push(val);
        // min可能为空
        if (dMin.isEmpty()) {
            dMin.push(val);
        } else {
            // 这个非常关键
            dMin.push(Math.min(dMin.peek(), val));
        }
    }

    public void pop() {
        dMin.pop();
        dFull.pop();
    }

    public int top() {
        return dFull.peek();
    }

    public int getMin() {
        if (dMin.isEmpty()) {
            return dFull.peek();
        }
        return dMin.peek();
    }
}
