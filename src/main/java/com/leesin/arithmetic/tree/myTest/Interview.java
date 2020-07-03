package com.leesin.arithmetic.tree.myTest;

import com.leesin.arithmetic.tree.Traverse;
import com.leesin.arithmetic.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 10:24
 * @modified By:
 */
public class Interview {
    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        TreeNode head  = buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
        return head;
    }

    public static TreeNode buildTree(int[] preOrder, int pstart, int pend, int[] inOrder, int istart, int iend, Map map) {
        if (pstart > pend || istart > iend) {
            return null;
        }
        TreeNode head = new TreeNode(preOrder[pstart]+" ");
        int index = (int) map.get(inOrder[pstart]);
        //左递归
        buildTree(preOrder, pstart, pstart + index - istart, inOrder, istart, index-1, map);
        buildTree(preOrder, pstart + index - istart+1,pend , inOrder, index+1, iend, map);
        return head;
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 17};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode treeNode = buildTree(preorder, inorder);
        Traverse.levelOrder(treeNode);
    }
}
