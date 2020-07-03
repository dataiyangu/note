package com.leesin.arithmetic.list;

/**
 * @description: 合并两个有序链表
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 9:24
 * @modified By:
 */
public class Test2 {
    /**
     * @description: 递归方式
     * @name: mergeTowList
     * @param: head1 两个链表的头结点
     * @param: head2 两个链表的头结点
     * @return: com.leesin.arithmetic.list.ListNode
     * @date: 2020/6/30 0030 9:26
     * @auther: Administrator
     **/
    public static ListNode mergeTwoList(ListNode head1, ListNode head2) {
        //退出递归的条件
        //下次传进来的head1 head2 = null。那么上层的head.next就是null，说明已经到头了
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2; //head.next = head2
        }
        if (head2 == null) {
            return head1;//head.next = head1
        }
        //主要逻辑
        ListNode head = null;//合并之后的头结点
        if (head1.value > head2.value) { //链表1 的头结点 > 链表2 的头结点
            head = head2; //合并之后的头指针指向较小的节点
            head.next = mergeTwoList(head1, head2.next);//在剩余的节点中找下一个节点
        } else {
            head = head1;//合并之后的头指针指向较小的节点
            head.next = mergeTwoList(head1.next, head2);//第一个参数因为我们指向head1了
        }
        return head;//返回head
    }

    /**
     * 非递归的方式
     *
     * @description:
     * @name: mergeTwoList2
     * @param: head1
     * @param: head2
     * @return: com.leesin.arithmetic.list.ListNode
     * @date: 2020/6/30 0030 10:03
     * @auther: Administrator
     **/
    public static ListNode mergeTwoList2(ListNode head1, ListNode head2) {
        //思路：分别遍历两个链表，把另一个链表合并到当前链表中，合并到哪个链表？就是先看他们的首节点，首节点比较小的链表，
        //他作为我们最后合并之后的链表，把首节点大的链表的每一个元素按照位置合并到首节点比较小的链表当中

        if (head1 == null || head2 == null) {//head1 head2有一个为null，返回不为null的那个
            return head1 != null ? head1 : head2;
        }
        ListNode head = head1.value < head2.value ? head1 : head2;//找到头结点小的链表，基准链表
        //两个指针
        ListNode cur1 = head == head1 ? head1 : head2;//cur1指针指向头结点小的链表
        ListNode cur2 = head == head1 ? head2 : head1;//cur2指针指向头结点大的链表
        //cur2上的所有内容指向cur1
        ListNode pre = null;//指向cur1的前一个元素   在我看来是最后基准表的pre
        ListNode next = null;//指向cur2的后一个元素   在我看来是最后基准表的next
        while (cur1 != null && cur2 != null) {//两个链表都没有到末尾
            //【第一次默认走这里】
            if (cur1.value <= cur2.value) {//初始元素是不是cur1的元素 比 cur2的元素小于或等于 cur1的第一个肯定是小的
                //方便遍历【pre、curl1都往后移 cur1 就是基准表，直接往后移，什么也不用管】
                pre = cur1;//pre指向cur1 初始 这里并不是前一个的意思，只是初始化pre，指的是第一个节点
                //方便遍历
                cur1 = cur1.next;//直接往后移动一位即可，不管cur2了
            } else {//否则把cur2指向的元素合并进cur1里面 cur2头插cur1
                //有点像插入一个新元素
                //【cur2 插入到cur1前面】    【pre  （cur1|cur2） next】  只有第一次【pre(cur1) (cur1|cur2) next】
                next = cur2.next;//记录下cur2的下一个节点的位置
                //这里是[pre cur1] - > [pre cur2 curl1 ] 插入了curl2
                pre.next = cur2;//cur1前一个元素的位置的下一个节点原来指向cur1，现在指向cur2 pre.next不能写成cur1？cur1不一定是pre.next
                cur2.next = cur1;//cur2的下一个元素的节点指向cur1
                //pre和next的位置重新变更下 往后移动一个，【方便遍历】
                pre = cur2;// pre指向cur2  主表的指针往后
                cur2 = next;//cur2指向记录的next  //cur2的指针也往后
                /*
                * 记忆 ：
                * pre.next cur2.next
                * pre cur2
                * */
            }
        }
        //cur1 cur2有一个到末尾了，字节把末尾的添加到基准链表
        pre.next = cur1 == null ? cur2 : cur1; //判断cur1是不是已经指向末尾了，是的话next指向cur2，否则指向cur1
        return head;//返回head
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        //两个有序链表
        node1.next = node3;//链表13
        node2.next = node4;//链表24

        //=====注意下面两个不能同时测试，只能注释掉一个，因为其中一个已经把初始链表改变了====

        // ListNode listNode = mergeTwoList(node1, node2);
        // while (listNode != null) {
        //     System.out.print(listNode.value + " ");
        //     listNode = listNode.next;
        // }


        ListNode listNode2 = mergeTwoList2(node1, node2);
        while (listNode2 != null) {
            System.out.print(listNode2.value + " ");
            listNode2 = listNode2.next;
        }
    }
}
