package com.leesin.arithmetic.tree;

/**
 * @description:一个树的节点
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 22:44
 * @modified By:
 */
public class TreeNode {
    public String value;//value
    public TreeNode left;//左子树指针
    public TreeNode right;//右子树指针
    //构造方法
    public TreeNode(String value) {
        this.value = value;
    }
}
