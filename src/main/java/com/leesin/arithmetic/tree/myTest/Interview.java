package com.leesin.arithmetic.tree.myTest;

import com.leesin.arithmetic.tree.Traverse;
import com.leesin.arithmetic.tree.TreeNode;

import java.util.HashMap;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 10:24
 * @modified By:
 */
public class Interview {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        TreeNode treeNode = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        return treeNode;
    }

    public static TreeNode buildTree(int[] preorder, int prstart, int preend, int[] inorder, int instart, int inend, HashMap<Integer, Integer> map) {
        if (prstart > preend || instart > inend) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[prstart]+"");
        Integer index = map.get(preorder[prstart]);
        head.left = buildTree(preorder, prstart + 1, prstart + index - instart, inorder, instart, index-1, map);
        head.right  = buildTree(preorder, prstart + index - instart + 1,preend, inorder, index + 1, inend, map);
        return head;
    }

    public static void main(String[] args) {
        int[] preorder = {2, 5, 4, 6, 7, 8};
        int[] inorder = {2, 5, 4, 6, 7, 8};

        TreeNode treeNode = buildTree(preorder, inorder);
        Traverse.levelOrder(treeNode); //2 5 4 6 7 8


//              6
//           /     \
//          5       7
//         / \       \
//        2   4       8
    }
}
