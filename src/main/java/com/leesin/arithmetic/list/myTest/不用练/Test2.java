package com.leesin.arithmetic.list.myTest.不用练;

import com.leesin.arithmetic.list.ListNode;

/**
 * @description: 合并有序链表
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 10:44
 * @modified By:
 */
public class Test2 {
    public static ListNode mergeList(ListNode head1, ListNode head2) {
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
            head.next = mergeList(head1.next, head2);
        }
        if (head.value >= head2.value) {
            head = head2;
            head.next = mergeList(head1, head2.next);
        }
        return head;
    }

    public static ListNode mergeList2(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        ListNode head = head1.value < head2.value ? head1 : head2;

        ListNode curl1 = head == head1 ? head1 : head2;
        ListNode curl2 = head == head1 ? head2 : head1;
        ListNode pre = null;
        ListNode next = null;
        while (curl1 != null && curl2 != null) {
            if (curl1.value <= curl2.value) {
                pre = curl1;
                curl1 = curl1.next;
            } else {
                next = curl2.next;
                pre.next = curl2;
                curl2.next = curl1;
                pre = curl2;
                curl2 = next;
            }
        }
        pre.next = curl1 == null ? curl2 : curl1;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node3;
        node2.next = node4;
        // 1
        // 2
        // 3
        // 4
        // ListNode node = mergeList(node1, node2);
        // while (node != null) {
        //     System.out.println(node.value + " ");
        //     node = node.next;
        // }

        ListNode node = mergeList2(node1, node2);
        while (node != null) {
            System.out.println(node.value+" ");
            node = node.next;
        }
    }
}

