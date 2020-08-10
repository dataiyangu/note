package com.leesin.arithmetic.tree.myTest;

import com.leesin.arithmetic.tree.TreeNode;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/9 0009 11:10
 * @modified By:
 */
public class Traverse尚硅谷 {
//ps：这里和尚硅谷的不是很一样，方法内容思想一致

    public static void frontTraverse(TreeNode node) {
        System.out.print(node.value);
        if (node.left != null) {
            frontTraverse(node.left);
        }
        if (node.right != null) {
            frontTraverse(node.right);
        }
    }

    public static void midTraverse(TreeNode node) {
        if (node.left != null) {
            midTraverse(node.left);
        }
        System.out.print(node.value);
        if (node.right != null) {
            midTraverse(node.right);
        }
    }

    public static void postTraverse(TreeNode node) {
        if (node.left != null) {
            postTraverse(node.left);
        }
        if (node.right != null) {
            postTraverse(node.right);
        }
        System.out.print(node.value);
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

        frontTraverse(A);//A B D H I E J C F K G
        System.out.println();
        midTraverse(A);//H D I B E J A F K C G
        System.out.println();
        postTraverse(A);//H I D J E B K F G C A
        System.out.println();
        // levelOrder(A);//A B C D E F G H I J K
    }
}
