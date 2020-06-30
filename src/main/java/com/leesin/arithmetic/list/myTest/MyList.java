package com.leesin.arithmetic.list.myTest;

import com.leesin.arithmetic.list.ListNode;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 16:48
 * @modified By:
 */
public class MyList {
    public static void headInsert(ListNode head,ListNode newhead) {
        ListNode old = head;
        head = newhead;
        head.next = old;
    }

    public static void tailInsert(ListNode tail, ListNode newhead) {
        ListNode old = tail;
        tail = newhead;
        tail.next = null;
        old.next = tail;
    }

    public static void traverse(ListNode head) {
        while (head != null) {
            System.out.print(head.value+" ");
            head = head.next;
        }
        System.out.println();
    }

    public static int find(ListNode head, int value) {
        int index = -1;
        int count = 0;
        while (head != null) {
            if (head.value == value) {
                index = count;
                return index;
            }
            count++;
            head = head.next;
        }
        return index;
    }

    public static void insert(ListNode p,ListNode s) {
        ListNode next = p.next;
        p.next = s;
        s.next = next;
    }

    public static void delete(ListNode head,ListNode p) {
        if (p != null && p.next != null) {
            ListNode q = p.next;
            p.value = q.value;
            p.next = q.next;
            q = null;
        }
        if (p == null) {
            while (head!=null){
                if (head.next != null && head.next == p) {
                    head.next = null;
                    break;
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
        headInsert(node1,newhead);
        //遍历 --- 0 1 2 3
        traverse(newhead);
        //尾插
        ListNode newtail = new ListNode(4);
        tailInsert(node3,newtail);
        //遍历 --- 0 1 2 3 4
        traverse(newhead);
        //查找 --- 3
        System.out.println(find(newhead,3));
        //普通插入
        ListNode node = new ListNode(5);
        //node3后面插入5
        insert(node3,node);
        //查找 --- 0 1 2 3 5 4
        traverse(newhead);
        //删除node3
        delete(newhead,node3);
        //查找 --- 0 1 2 5 4
        traverse(newhead);
    }
}
