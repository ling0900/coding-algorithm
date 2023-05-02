package code.lh.algorithm.leetcode.lc24;

import code.lh.algorithm.leetcode.base.ListNode;
import org.junit.Test;

/**
 * The type Solution.
 */
public class Solution {
    /**
     * Swap pairs list node.
     *
     * @param head the head
     * @return the list node
     */
    public  ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }


        ListNode resultHead = head.next;

        ListNode toSwap = new ListNode(0, head);

        swapTwoNodes(toSwap);

        return resultHead;

    }


    /**
     * Swap two nodes list node.
     *
     * @param helpHead the help head
     * @return the list node
     */
// 定义一个交换的函数，两两交换的函数。返回值是第二个node
    public  ListNode swapTwoNodes(ListNode helpHead) {

        if (helpHead.next == null || helpHead.next.next == null) {
            return null;
        }

        ListNode a = helpHead.next;
        ListNode b = helpHead.next.next;
//        ListNode c = helpHead.next.next.next;

        // 重新分配
        helpHead.next = b;
        a.next = b.next;
        b.next = a;

        return swapTwoNodes(a);
    }


    /**
     * Main 2.
     */
    @Test
    public void main2() {
        System.out.println("90fds90f9ds0a");
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.next = b;
//        b.next = c;
//        c.next = d;


        ListNode listNode = this.swapPairs(a);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
