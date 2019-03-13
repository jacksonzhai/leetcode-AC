/**
 * Definition for a binary tree node.
 * public class ThreadNode {
 * int val;
 * ThreadNode left;
 * ThreadNode right;
 * ThreadNode(int x) { val = x; }
 * }
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TraverseATreeWithoutRecursion {
    public List<Integer> preOderTree(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.empty()) {
            TreeNode op = stack.pop();
            list.add(op.val);
            if (op.right != null) stack.push(op.right);
            if (op.left != null) stack.push(op.left);
        }
        return list;

    }

    public List<Integer> inOrderTree(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;

        }
        while (!stack.empty()) {
            TreeNode op = stack.pop();
            list.add(op.val);
            temp = op.right;
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;

            }
        }
        return list;

    }

    public List<Integer> postOrderTree(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        while (root != null) {
            stack.push(root.right);
            stack.push(root);
            root = root.left;
        }
        while (!stack.empty()) {
            root = stack.pop();
            if(root == null){
                continue;
            }
            else if (root.right != null && !stack.empty() && root.right == stack.peek()) {
                stack.pop();
                stack.push(root);
                root = root.right;
            } else {
                list.add(root.val);
                root = null;
            }
            while (root != null) {
                stack.push(root.right);
                stack.push(root);
                root = root.left;
            }
        }

        return list;
    }

}
