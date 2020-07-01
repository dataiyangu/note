package com.leesin.arithmetic.tree;

/**
 * @description:查找两个节点的最近公共祖先
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 9:06
 * @modified By:
 */
public class LowestAncestor {
    /**
     * @description: 查找p q的最近公共祖先 递归
     * @name: lowesCommonAncestor
     * @param: root 根节点
     * @param: p 节点p
     * @param: q 节点q
     * @return: com.leesin.arithmetic.tree.TreeNode
     * @date: 2020/7/1 0001 9:07
     * @auther: Administrator
    **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //终止条件
        if (root == null||root==p||root==q) {//最近公共祖先一定是root(公共祖先可以是自己)，直接返回root
            return root;
        }
        //递归在左子树中进行查找，再在右子树中进行查找
        //left\ritght都是两个子树的最小公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //查找结果均不为null，说明两边均有，就是在左边可以找到p和q的某一个，右边也可以找到p和q的某一个
        //这样他们两个的最近公共祖先，只可能是root，因为左右子树全都有
        //沿着root往下找两边都有，说明就是root
        if (left != null && right != null) {
            return root;
        }
        //否则，看左子树是不是为空，如果不为空的话，最近的一个公共祖先肯定就是在左子树上面，否则就是右子树上面
        //沿着root往下找，那边有输出那边
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

        LowestAncestor lowestAncestor = new LowestAncestor();
        TreeNode treeNode = lowestAncestor.lowestCommonAncestor(A, B, F);
        System.out.println(treeNode.value);//A
    }
}
