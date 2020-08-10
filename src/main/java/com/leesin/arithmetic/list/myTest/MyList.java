package com.leesin.arithmetic.list.myTest;

import com.leesin.arithmetic.list.ListNode;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 20:45
 * @modified By:
 */
public class MyList {

    //头插
    public static void headInsert(ListNode head, ListNode newNode) {
        ListNode old = head;
        head = newNode;
        head.next = old;
    }

    //尾插
    public static void tailInsert(ListNode tail, ListNode newNode) {
        ListNode old = tail;
        tail = newNode;
        old.next = tail;
        tail.next = null;
    }

    //遍历
    public static void traverse(ListNode head) {
        while (head != null) {
            System.out.print(head.value);
            head = head.next;
        }
        System.out.println();
    }

    //查找
    public static int find(ListNode head, int value) {
        int index = 0;
        while (head != null) {
            if (head.value == value) {
                break;
            }
            index++;
            head = head.next;
        }
        return index;
    }

    //插入
    public static void insert(ListNode p, ListNode s) {
        ListNode oldNext = p.next;
        p.next = s;
        s.next = oldNext;
    }

    //删除
    public static void delete(ListNode head, ListNode p) {
        if (p.next != null) {
            ListNode q = p.next;
            p.value = q.value;
            p.next = q.next;
        } else if (p.next == null) {
            while (head != null) {
                if (head.next == p) {
                    head.next = null;
                }
                head = head.next;
            }
        }
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        //遍历 --- 1 2 3
        traverse(node1);
        //头插
        ListNode newhead = new ListNode(0);
        headInsert(node1, newhead);
        //遍历 --- 0 1 2 3
        traverse(newhead);
        //尾插
        ListNode newtail = new ListNode(4);
        tailInsert(node3, newtail);
        //遍历 --- 0 1 2 3 4
        traverse(newhead);
        //查找 --- 3
        System.out.println(find(newhead, 3));
        //普通插入
        ListNode node = new ListNode(5);

        //node3后面插入5
        insert(node3, node);
        //查找 --- 0 1 2 3 5 4
        traverse(newhead);

        //删除node3
        delete(newhead, node3);
        //查找 --- 0 1 2 5 4
        traverse(newhead);

    }
}
