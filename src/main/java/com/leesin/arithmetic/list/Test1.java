package com.leesin.arithmetic.list;

/**
 * @description: 单链表反转  、 单链表取中间值
 * @author: Leesin Dong
 * @date: Created in 2020/6/29 0029 23:08
 * @modified By:
 */
public class Test1 {
    //反转链表 时间复杂度O(n) 空间复杂度O(1)
    //没有这个约束条件的话，有很多方式可以做，包括可以采用栈，链表放到栈里面然后再弹出，就是一种反转

    /**
     * @description:  反转链表
     * @name: reverse
     * @param: head 参数头结点
     * @return: com.leesin.arithmetic.list.ListNode
     * @date: 2020/6/29 0029 23:15
     * @auther: Administrator
    **/
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;//当前节点的上一个节点
        ListNode next = null;//当前节点的下一个节点
        while (head != null) {
            next = head.next;//记录下一个节点的位置
            //==1 反转就这一步
            head.next = pre;//当前节点的尾指针，即下一个节点，由原来的位置指向前面的位置
            //==2 整体往后移，为了遍历
            pre = head; //前一个指针pre、当前节点的指针都需要往后移动一位，这样整体向后移了一位，以便进行下一次的便利
            head = next;//为了遍历
        }
        //新的头节点
        return pre;//head = null 跳出循环的时候，pre指向的已经是链表的最后一个节点，只需要把pre返回 //已经是新的反转后的第一个节点
    }

    /**
     * @description: 单链表取中间的节点，如果单链表是奇数个，取的正好是中间那个，如果单链表是偶数个，取到的是中间的两个，取到前面那个
     * 取中间节点（偶数个 取中间节点是前面那个）
     * @name: getMid
     * @param: head 传入head节点
     * @return: com.leesin.arithmetic.list.ListNode
     * @date: 2020/6/30 0030 8:55
     * @auther: Administrator
    **/
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
}

