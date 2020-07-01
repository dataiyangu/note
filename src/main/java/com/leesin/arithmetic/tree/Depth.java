package com.leesin.arithmetic.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description: 二叉树的最大深度、最小深度
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 7:12
 * @modified By:
 */
public class Depth {
    /**
     * @description: 递归最大深度
     * @name: maxDepth
     * @param: root
     * @return: int
     * @date: 2020/7/1 0001 7:17
     * @auther: Administrator
     **/
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);//递归调用左子树的最大深度
        int right = maxDepth(root.right);//递归调用右子树的最大深度
        //左子树和右子树中更大的那个
        //+1？因为是左子树、右子树的最大深度，还要加root
        return Math.max(left, right) + 1;
    }

    /**
     * @description: 非递归最大深度
     * @name: maxDepth2
     * @param: root
     * @return: int
     * @date: 2020/7/1 0001 7:19
     * @auther: Administrator
     **/
    public int maxDepth2(TreeNode root) {
        //利用层次遍历的思想
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;//规定深度，每次进行累加，因为是层次遍历
        while (!queue.isEmpty()) {
            level++; //就多了两行 多了两行level
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }

    /**
     * @description: 递归最小深度
     * @name: minDepth
     * @param: root
     * @return: int
     * @date: 2020/7/1 0001 7:26
     * @auther: Administrator
     **/
    public int minDepth(TreeNode root) {
        //如果节点为null的时候，直接返回0
        //如果左右子树均为null，返回1
        //如果只有左子树为null，返回右子树最小深度+1
        //如果只有右子树为null，返回左子树最小深度+1
        //如果左右子树均不为null，返回两者中较小的深度+1
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;//递归
        }
        if (root.left != null && root.right == null) {
            return minDepth((root.left)) + 1;
        }
        //左右子树均不为nnull的情况
        int left = minDepth(root.left);//左子树的最小深度
        int right = minDepth(root.right);//右子树的最小深度
        return Math.min(left, right) + 1;//返回left、right中较小的那个，+1 ：根这层
    }

    /**
     * @description: 非递归最小深度
     * @name: minDepth2
     * @param: root
     * @return: int
     * @date: 2020/7/1 0001 8:15
     * @auther: Administrator
     **/
    public int minDepth2(TreeNode root) {
        //跟上面最大深度迭代一样，只是多了一步，改了一步
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                //只有这里多了一个判断  左右子树都为null，就到这层了，
                if (node.left == null && node.right == null) {
                    return level;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        //还有这里return 0
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

        Depth depth = new Depth();
        System.out.println(depth.maxDepth(A));//4
        System.out.println(depth.maxDepth2(A));//4
        System.out.println(depth.minDepth(A));//3
        System.out.println(depth.minDepth2(A));//3
    }
}
