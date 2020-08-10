package com.leesin.arithmetic.tree;

import java.util.HashMap;

/**
 * @description: 先序中序数组组合重构二叉树
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 9:38
 * @modified By:
 */
public class Interview {
    //思路：先通过前序遍历第一个元素确定根的元素，然后查找该元素在中序遍历中的位置，采用递归实现

    //需要一个方法调用buildTree （下面的）
    public static TreeNode buidlTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return null;
        }
        //【往map里面set】
        HashMap<Integer, Integer> map = new HashMap<>();
        //初始化map，需要存到中序遍历数组里面的每个元素的下标
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);//这样取元素的时间复杂度降为了1
        }
        //直接调用
        //pstart 起始位置刚开始是0
        return buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);
    }

    /**
     * @description:先序中序数组组合重构二叉树
     * @name: buildTree
     * @param: preOrder 前序遍历数组
     * @param: pstart 前序遍历开始的位置
     * @param: pend 前序遍历结束的位置
     * @param: inOrder 中序遍历的数组
     * @param: istart 中序遍历起始的位置
     * @param: iend 中序遍历结束的位置
     * @param: map hashmap提高查找效率，因为需要在中序遍历中查找到，根节点的下标
     * @return: com.leesin.arithmetic.tree.TreeNode
     * @date: 2020/7/1 0001 9:42
     * @auther: Administrator
     **/
    public static TreeNode buildTree(int[] preOrder, int pstart, int pend, int[] inOrder, int istart, int iend, HashMap<Integer, Integer> map) {
        // 思路：先通过前序遍历第一个元素确定根的元素，然后查找该元素在中序遍历中的位置，采用递归实现//
        // 先序 中 左 右 确定中
        //中序  左 中 右  先序中的根节点位置

        //因为采用递归的方式，所以这里是终止条件 start一直都在+
        if (pstart > pend || istart > iend) {
            return null;
        }
        //在中序数组中，查找根节点的下标
        //构造根节点，因为需要build一个tree

        //先序遍历的首元素
        //因为treenode value是string，这里是int，所以转成string
        TreeNode head = new TreeNode(preOrder[pstart] + "");   //【确定新树头】
        //找根节点的下标，在中序遍历中的位置
        //map.get时间复杂度是o1
        int index = map.get(preOrder[pstart]);//【确定 中序遍历中间节点】
        //构造左子树，递归
        //preOrder传进去，左子树的起始点 pstart+1
        //左子树的终止点，我们已经确定index坐标，在中序遍历中index坐标左边的全是左子树，右边的全是右子树，所以可以知道左子树的个数
        //即index-istart，这里只需要用pstart+index-start就是终止元素，前序遍历的终止元素
        //【index-istart，先序中左子树个数 因为中序遍历中间节点的左边全是左子树】
        //【重点：中序遍历 中间节点的左边全是左子树】
        //这里构建关系                                            先序 到所有左子树的结尾                           index-1 全部是左子树
        head.left = buildTree(preOrder, pstart + 1, pstart + index - istart, inOrder, istart, index - 1, map);
        //构造右子树
        //pstart：上面参数中pend+1 ：pstart + index - istart
        //istart:index+1
        //iend：iend
        //                                                   右子树                                index+1全部是右树
        head.right = buildTree(preOrder, pstart + index - istart + 1, pend, inOrder, index + 1, iend, map);
        return head;
    }

    public static void main(String[] args) {
        int[] preorder = {2, 5, 4, 6, 7, 8};
        int[] inorder = {2, 5, 4, 6, 7, 8};

        TreeNode treeNode = buidlTree(preorder, inorder);
        Traverse.levelOrder(treeNode); //2 5 4 6 7 8


//              6
//           /     \
//          5       7
//         / \       \
//        2   4       8
    }
}
