package com.leesin.arithmetic.list.myTest;

import com.leesin.arithmetic.list.ListNode;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 13:48
 * @modified By:
 */
public class Interview1 {

    public static ListNode[] getLists(ListNode head) {
        //最后需要返回的两个链表的头结点
        ListNode head1 = null;
        ListNode head2 = null;

        //【因为head1 head2只作为链表头，最后直接输出即可，不便于将遍历，所以cur1 cur2 接替他做这个事情，head1 head2 指向它们即可】
        //
        //两个指针，遍历用的
        ListNode cur1 = null;
        ListNode cur2 = null;

        int count = 1;//用来计数的变量，初始值1  初始值1代表数组中的第1位，通过这个来将数组拆成两个
        while (head != null) {
            if (count % 2 == 1) {//奇数节点
                //【可以把if else 颠倒下，看的方便】
                if (cur1 != null) {
                    //【直接添加到链表后面，因为cur1是空的，直接添加即可】
                    cur1.next = head; //cur1的next值指向head节点  把新的元素放到原来指针所指元素后面
                    cur1 = cur1.next;//cur1指向他的下一个节点  把指针指向，新的元素 【这里写成head也是可以的】
                } else {//cur1为null，即最开始的情况
                    cur1 = head;//cur1直接等于head
                    head1 = cur1;//head1指向cur1  【这里写成head1 = head也是可以的】
                }
            } else {//偶数位操作，同理
                if (cur2 != null) {//cur2不为null
                    cur2.next = head;//cur2的next指向head
                    cur2 = cur2.next;//cur2指向他的下一位 【这里写成head也是可以的】
                } else {//cur2为null
                    cur2 = head;//cur2指向head，这步只会执行一次，
                    head2 = cur2;//head2指向cur2 【这里写成head1 = head也是可以的】
                }
            }
            head = head.next;//head指向head.next进行遍历
            count++;//计数器++
        }
        //跳出循环之后，两个末尾元素的下一个都指向null 这里cur1 cur2 其实就是指向最后一个元素的指针
        cur1.next = null;
        cur2.next = null;
        ListNode[] nodes = new ListNode[]{head1, head2};//声明一个数组返回
        return nodes;
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

    public static ListNode merge2List(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.value < head2.value ? head1 : head2;
        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = null;
        ListNode next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
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

