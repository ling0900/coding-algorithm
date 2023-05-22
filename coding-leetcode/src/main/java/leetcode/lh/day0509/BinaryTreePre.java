package leetcode.lh.day0509;

import leetcode.lh.ListNode;
import leetcode.lh.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePre {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            preorderTraversal(root, res);
        }
        return res;
    }

    private void preorderTraversal(TreeNode node, List<Integer> res) {


        if (node == null) {
            return;
        }
        res.add(node.val);
        preorderTraversal(node.left, res);
        preorderTraversal(node.right, res);
    }
}
