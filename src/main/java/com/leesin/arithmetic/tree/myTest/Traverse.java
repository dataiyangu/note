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
        Stack<TreeNode> stack = new Stack();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.print(pop.value);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    public static void inOrder(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head!=null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.value);
                head = head.right;
            }
        }
    }

    public static void postOrder(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            stack1.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        while (!stack1.isEmpty()) {
            System.out.print(stack1.pop().value);
        }
    }

    public static void levelOrder(TreeNode head) {

        Queue queue = new ArrayDeque();
        queue.offer(head);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = (TreeNode) queue.poll();
                System.out.print(poll.value);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
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

        preOrder(A);//A B D H I E J C F K G
        System.out.println();
        inOrder(A);//H D I B E J A F K C G
        System.out.println();
        postOrder(A);//H I D J E B K F G C A
        System.out.println();
        levelOrder(A);//A B C D E F G H I J K
    }
}
