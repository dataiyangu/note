package com.leesin.arithmetic.list;

/**
 * @description: 单链表归并排序 nlogn
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 15:20
 * @modified By:
 */

/*
* 测试 leetcode 148题
* */
public class Interview2 {
    //归并排序算法
    public static ListNode sortList(ListNode head) {
        //0个或者1个元素，不需要排序，直接返回即可 递归结束条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);//得到中间节点
        ListNode right = mid.next;//mid节点下一个节点
        //需要把链表咬断，因为原来是一个链表，现在需要一个归并操作，即递归  变成两个链表
        mid.next = null;//咬断链表
        ListNode node = merge(sortList(head), sortList(right));//递归调用，归并排序  两个参数，每次都是排序好的链表
        return node;//归并排序好了之后的头结点
    }


    //取中点
    public static ListNode getMid(ListNode head) {
        //思路：一个快指针、一个慢指针，快指针每次走两步，慢指针每次走一步，快指针走完之后，慢指针就是中间节点的位置
        if (head == null) {        //head = null说明链表不存在，返回 null就行
            return head;
        }
        ListNode fast = head;//快指针 指向头部
        ListNode slow = head;//慢指针 指向头部

        while (fast.next != null && fast.next.next !=null) {//遍历 快指针走两步，慢指针走一步
            // 判断两次，因为fast要走两步，不能因为下下个是null，不能遍历了
            slow = slow.next; //slow一步
            fast = fast.next.next; //fast两步
        }
        //快指针走完，慢指针 这就是中间节点
        return slow;
    }

    //合并有序链表 非递归
    public static ListNode merge(ListNode head1, ListNode head2) {
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
            if (cur1.value <= cur2.value) {//初始元素是不是cur1的元素 比 cur2的元素小于或等于 cur1的第一个肯定是小的
                pre = cur1;//pre指向cur1 初始 这里并不是前一个
                //方便遍历
                cur1 = cur1.next;//直接往后移动一位即可，不管cur2了
            } else {//否则把cur2指向的元素合并进cur1里面 cur2头插cur1
                //有点像插入一个新元素
                next = cur2.next;//记录下cur2的下一个节点的位置
                pre.next = cur2;//cur1前一个元素的位置的下一个节点原来指向cur1，现在指向cur2
                cur2.next = cur1;//cur2的下一个元素的节点指向cur1
                //pre和next的位置重新变更下 往后移动一个，方便遍历
                pre = cur2;// pre指向cur2
                cur2 = next;//cur2指向记录的next
            }
        }
        //cur1 cur2有一个到末尾了，字节把末尾的添加到基准链表
        pre.next = cur1 == null ? cur2 : cur1; //判断cur1是不是已经指向末尾了，是的话next指向cur2，否则指向cur1
        return head;//返回head
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
        head = sortList(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
}
