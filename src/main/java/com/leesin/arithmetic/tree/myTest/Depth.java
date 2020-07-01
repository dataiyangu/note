package com.leesin.arithmetic.tree.myTest;

import com.leesin.arithmetic.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 8:20
 * @modified By:
 */
public class Depth {
    public int MaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = MaxDepth(root.left);
        int right = MaxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int MaxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty() && root != null) {
            level++;
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return level;
    }

    public int minDepth(TreeNode root) {
        if (root != null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null && root.right == null) {
            return minDepth(root.right) + 1;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.left) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty() && root != null) {
            level++;
            int levelNum = queue.size();

            for (int i = 0; i < levelNum; i++) {
                TreeNode poll = queue.poll();

                if (poll.left == null && poll.right == null) {
                    return level;
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode J = new TreeNode("J");
        TreeNode K = new TreeNode("K");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.left = H;
        D.right = I;
        E.right = J;
        C.left = F;
        C.right = G;
        F.right = K;

        com.leesin.arithmetic.tree.Depth depth = new com.leesin.arithmetic.tree.Depth();
        System.out.println(depth.maxDepth(A));//4
        System.out.println(depth.maxDepth2(A));//4
        System.out.println(depth.minDepth(A));//3
        System.out.println(depth.minDepth2(A));//3
    }
}
