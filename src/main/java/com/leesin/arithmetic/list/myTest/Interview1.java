package com.leesin.arithmetic.list.myTest;

import com.leesin.arithmetic.list.ListNode;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 13:48
 * @modified By:
 */
public class Interview1 {
    /*
     * 1 拆分
     * 2 偶数反转
     * 3 合并
     * */

    public static ListNode[] getLists(ListNode head) {
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode cur1 = null;
        ListNode cur2 = null;
        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                if (cur1 != null) {
                    cur1.next = head;
                    cur1 = head;
                } else {
                    cur1 = head;
                    head1 = head;//这里注意不能是head，因为奇数偶数 第二次进来head就变了
                }
            } else {
                if (cur2 != null) {
                    cur2.next = head;
                    cur2 = head;
                } else {
                    cur2 = head;
                    head2 = head;
                }
            }
            head = head.next;
            count++;
        }
        cur1.next = null;
        cur2.next = null;
        ListNode[] nodes = new ListNode[]{head1, head2};//声明一个数组返回
        return nodes;    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static ListNode merge2List(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode head = null;
        if (head1.value > head2.value) {
            head = head2;
            head.next = merge2List(head1, head2.next);
        } else {
            head = head1;
            head.next = merge2List(head1.next, head2);
        }
        return head;
    }

    public static ListNode init() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        return node1;
    }
    public static void main(String[] args) {
        ListNode head = init();
        //拆分成奇数、偶数两个链表
        ListNode[] lists = getLists(head);
        //得到两个链表头结点
        ListNode head1 = lists[0];
        ListNode head2 = lists[1];

        //偶数链表反转
        head2 = reverse(head2);

        //两个链表合并
        //这个一定是head
        head =  merge2List(head1, head2);

        while (head != null) {
            System.out.print(head.value+" ");
            head = head.next;
        }

    }
}

