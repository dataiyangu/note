package com.leesin.arithmetic.tree.myTest;

import com.leesin.arithmetic.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 6:37
 * @modified By:
 */
public class Traverse {
    public static void preOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.println(pop);
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    public static void postOrder(TreeNode head) {

    }

    public static void inOrder(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop);
                head = head.right;
            }
        }

    }

    public static void levelOrder(TreeNode head) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                System.out.println(poll);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
        }

    }
    public static void main(String[] args) {
        TreeNode A  = new TreeNode("A");
        TreeNode B  = new TreeNode("B");
        TreeNode C  = new TreeNode("C");
        TreeNode D  = new TreeNode("D");
        TreeNode E  = new TreeNode("E");
        TreeNode F  = new TreeNode("F");
        TreeNode G  = new TreeNode("G");
        TreeNode H  = new TreeNode("H");
        TreeNode I  = new TreeNode("I");
        TreeNode J  = new TreeNode("J");
        TreeNode K  = new TreeNode("K");

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

        preOrder(A);
        System.out.println();
        inOrder(A);
        System.out.println();
        postOrder(A);
        System.out.println();
        levelOrder(A);
    }
}
