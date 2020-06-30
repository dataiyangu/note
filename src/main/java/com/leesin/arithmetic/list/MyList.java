package com.leesin.arithmetic.list;

/**
 * @description: 链表操作
 * @author: Leesin Dong
 * @date: Created in 2020/6/29 0029 21:42
 * @modified By:
 */
public class MyList {
    /*
    * 总结：两个参数：原节点、新节点
    * */

    /**
     * @description: 头插
     * @name: headInsert
     * @param: head 链表头结点 即原节点
     * @param: newHead 新插入的节点
     * @return: void
     * @date: 2020/6/29 0029 21:46
     * @auther: Administrator
    **/
    public static void headInsert(ListNode head, ListNode newhead) {
        //old 、 head都只是指针而已
        //old->head->内存  old指向head指针所对应的区域
        //记录原来节点的指针 old指针指向head节点的位置
        ListNode old = head;
        //head-> newHead - > 内存
        //头节点指针指向新节点的位置
        head = newhead;
        //新的头结点的next，指向原来的old指针
        head.next = old;
    }

    /**
     * @description: 尾插
     * @name: tailInsert
     * @param: tail 原来尾结点
     * @param: newHead 新节点
     * @return: void
     * @date: 2020/6/29 0029 21:58
     * @auther: Administrator
    **/
    public static void tailInsert(ListNode tail, ListNode newtail) {
        //记录原来尾结点的位置
        ListNode old = tail;
        //新的尾结点的指针，指向newtail
        tail = newtail;
        //新的尾结点的next指向null，因为尾结点的下一个节点是null
        tail.next = null;
        //原来记录的尾结点的位置 next指针 指向新的尾结点
        old.next = tail;
    }

    /**
     * @description:  遍历
     * @name: traverse
     * @param: head 头结点
     * @return: void
     * @date: 2020/6/29 0029 22:14
     * @auther: Administrator
    **/
    public static void traverse(ListNode head) {
        //while循环，因为单链表只能从头开始遍历
        //head不为null的时候
        while (head != null) {
            //打印出当前元素的值
            System.out.print(head.value+" ");
            //节点指向下一个节点
            head = head.next;
        }
        //方便操作，最后回车一下
        System.out.println();
    }

    /**
     * @description: 遍历查找  单链表查找元素时间复杂度（o(n)，所以只能通过遍历的方式）
     * @name: find
     * @param: head 头结点
     * @param: value 要找的value值（从头到尾第一个查找到的）
     * @return: int 返回查找到的下标
     * @date: 2020/6/29 0029 22:21
     * @auther: Administrator
    **/
    public static int find(ListNode head,int value) {
        // 需要返回的下标先声明一下，刚开始声明成-1，如果没找到的话，就会返回-1
        int index = -1;
        //按照遍历的方式 当head不为null
        //count累加知道循环的次数，从而知道当前的下标
        int count = 0;
        while (head != null) {
            //head的value==当前给的value值，说明找到了
            if (head.value == value) {
                //index用count赋值
                index = count;
                return index;
            }
            //没有找到count++
            count++;
            head = head.next;
        }
        //没有找到index是-1
        return index;
    }

    /**
     * @description: 一般的插入操作 p节点后面插入s节点
     * @name: insert
     * @param: p
     * @param: s
     * @return: void
     * @date: 2020/6/29 0029 22:28
     * @auther: Administrator
    **/
    public static void insert(ListNode p, ListNode s) {
        //记录下p节点后面的节点的指针
        ListNode next = p.next;
        //p节点next指向s节点
        p.next = s;
        //s节点next指向原来p节点后面的节点
        s.next = next;
    }

    /**
     * @description:  删除节点
     * @name: delete
     * @param: head 链表头结点head
     * @param: p 将要删除的节点，q节点
     * @return: void
     * @date: 2020/6/29 0029 22:32
     * @auther: Administrator
    **/
    public static void delete(ListNode head,ListNode p) {
        //只要找到q的前驱结点，前驱节点的next指针，指向p的下一个节点即可，就可以把q删除掉
        //但是在单链表中，直接找p的上一个节点是不好找的，因为没有前驱的指针。
        //所以采取：p节点的next指针指向的下一个节点的内容复制到p，然后再把p的下一个节点删除掉，就相当于把p删除掉了
        //总结：复制p.next内容到p，删除p.next节点

        //p和p的下一个节点不为空，因为p的下一个节点为空，就不能将p的下一个节点的内容复制到p了
        if (p != null && p.next != null) {
            //记录下p的下一个节点 q
            ListNode q = p.next;
            //p的当前的值用q来赋值， 即p节点的下一个节点的值赋值给q
            p.value = q.value;
            //删除掉p的下一个节点  p指向了p的next的next
            p.next = q.next;
            //再把q进行释放
            q = null;
        }
        //但是如果删除的当前节点是最后一个节点
        //删除最后一个元素
        if (p.next == null) {
            //遍历查找到当前p节点的前一个节点，然后把前一个节点的下一个节点直接指向null即可
            //遍历：单链表没有前驱结点
            while (head != null) {
                //节点的下一个节点不为空，并且下一个节点=p的时候， 也就是找到p的上一个节点
                if (head.next != null && head.next == p) {
                    //当前元素的下一个节点指向空，就把q删除了
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

//          1 2 3
//         0 1 2 3
//         0 1 2 3 4
//         4
//         0 1 2 3 5 4
//         0 1 2 5 4
