package com.leesin.arithmetic.list.myTest;

import com.leesin.arithmetic.list.ListNode;

/**
 * @description:单链表归并排序 nlogn
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 16:23
 * @modified By:
 */
public class Interview2 {

   public static ListNode sortList(ListNode head) {
       if (head == null || head.next == null) {
           return head;
       }
       ListNode mid = getMid(head);
       ListNode next = mid.next;
       mid.next = null;
       ListNode listNode = mergeList(sortList(head), sortList(next));
       return listNode;
   }

    public static ListNode getMid(ListNode head) {
       if (head==null){
           return null;
       }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode mergeList(ListNode head1,ListNode head2) {
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
        } else {
            head = head2;
            head.next = mergeList(head2.next, head1);
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
        head = sortList(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
