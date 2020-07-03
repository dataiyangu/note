package com.leesin.arithmetic.list.myTest;

import com.leesin.arithmetic.list.ListNode;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 9:11
 * @modified By:
 */
public class Test1 {
    /*单链表反转*/
    public static ListNode reverseList(ListNode head) {
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

    /*单链表取中间值*/
    public static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        System.out.println(getMid(node1).value);//2

        ListNode listNode = reverseList(node1);//321
        while (listNode != null) {
            System.out.print(listNode.value + " ");
            listNode = listNode.next;
        }
    }
    //2
    // 3 2 1
}
