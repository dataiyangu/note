package com.leesin.arithmetic.list.myTest;

import com.leesin.arithmetic.list.ListNode;

/**
 * @description:一个链表奇数位升序，偶数位降序，对该链表排序 （头条面试）
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 13:48
 * @modified By:
 */
public class Interview1 {
    public static ListNode[] getLists(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode head1 = null;
        ListNode head12 = null;
        ListNode curl1 = null;
        ListNode curl2 = null;
        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                if (curl1 == null) {
                    curl1 = head;
                    head1 = curl1;
                } else {
                    curl1.next = head;
                    curl1 = curl1.next;
                }
            } else {
                if (curl2 == null) {
                    curl2 = head;
                    head12 = curl2;
                } else {
                    curl2.next = head;
                    curl2 = curl2.next;
                }
            }
            head = head.next;
            count++;
        }
        curl1.next = null;
        curl2.next = null;
        return new ListNode[]{head1, head12};
    }

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

    public static ListNode merge2List(ListNode head1,ListNode head2) {
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
        if (head1.value < head2.value) {
            head = head1;
            head.next = merge2List(head1.next, head2);
        } else {
            head = head2;
            head.next = merge2List(head2.next, head1);
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

        // 1 2 3 4 5 6 7 8 9
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

