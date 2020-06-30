package com.leesin.arithmetic.list;

/**
 * @description: 一个链表基数位升序，偶数位降序，对该链表排序 （头条面试）
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 12:10
 * @modified By:
 */
// 1 8 3 6 5 4 7 2 9  基数升序，偶数降序
// 1 2 3 4 5 6 7 8 9  想要
// 不可以：快速排序、归并排序 因为时间复杂度 nlog(n)
// 希望时间复杂度O(n)
public class Interview1 {
    /*
     * 分成三步，
     * 1. 按照基数位和偶数位分成两个链表
     * 2. 对偶数位链表进行翻转
     * 3. 对两个有序链表进行合并
     * */

    /**
     * @description: 基数位 偶数位 进行拆分
     * @name: getLists
     * @param: head 参数头结点
     * @return: com.leesin.arithmetic.list.ListNode[]
     * @date: 2020/6/30 0030 12:23
     * @auther: Administrator
     **/
    public static ListNode[] getLists(ListNode head) {
        //最后需要返回的两个链表的头结点
        ListNode head1 = null;
        ListNode head2 = null;

        //两个指针，遍历用的
        ListNode cur1 = null;
        ListNode cur2 = null;

        int count = 1;//用来计数的变量，初始值1
        while (head != null) {
            if (count % 2 == 1) {//奇数节点
                if (cur1 != null) {
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

        // 另一种写法
        /*
        *  if (count % 2 == 1) {
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
        * */
    }

    //链表反转
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

    //合并有序链表 （递归方式 比较简单）
    public static  ListNode mergeTwoList(ListNode head1, ListNode head2) {
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
            head.next = mergeTwoList(head1, head2.next);
        } else {
            head = head1;
            head.next = mergeTwoList(head1.next, head2);
        }
        return head;
    }
    /**
     * @description:
     * @name: init
     * @param:
     * @return: com.leesin.arithmetic.list.ListNode  返回头结点
     * @date: 2020/6/30 0030 13:13
     * @auther: Administrator
    **/
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
        head2 = reverseList(head2);

        //两个链表合并
       head =  mergeTwoList(head1, head2);

        while (head != null) {
            System.out.print(head.value+" ");
            head = head.next;
        }
    }
}
