package com.leesin.arithmetic.tree.myTest;

import com.leesin.arithmetic.tree.TreeNode;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 9:26
 * @modified By:
 */
public class LowestAncestor {
    private TreeNode lowestCommonnAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return root;
        }
        TreeNode left = lowestCommonnAncestor(root.left, p, q);
        TreeNode right = lowestCommonnAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
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

        com.leesin.arithmetic.tree.LowestAncestor lowestAncestor = new com.leesin.arithmetic.tree.LowestAncestor();
        TreeNode treeNode = lowestAncestor.lowestCommonAncestor(A, B, F);
        System.out.println(treeNode.value);//A
    }
}
