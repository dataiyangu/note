package com.leesin.arithmetic.greph;

/**
 * @description: 邻接表实现的无向图
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 11:59
 * @modified By:
 */
public class ListNDG {
    //基本存储结构：就是数组里面存的链表

    Vertex[] vertextLists;//邻接表数组
    int size;

    class Vertex{//邻接表节点类，单链表数据结构   类似单链表的定义
        char ch;
        Vertex next;

        Vertex(char ch) {//初始化方法
            this.ch = ch;
        }

        void add(char ch) {//加到链表尾
            Vertex node = this;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Vertex(ch);
        }
    }

    //初始化操作
    public ListNDG(char[] vertexs, char[][] edges) {
        size = vertexs.length;
        this.vertextLists = new Vertex[size];//确定邻接表大小
        //设置邻接表每一个节点 设置每个邻接表的起始节点 也就是  数组 A B C D E F G 课件中竖向排列的
        for (int i = 0; i < size; i++) {
            this.vertextLists[i] = new Vertex(vertexs[i]);
        }
        //存储编信息
        for (char[] c: edges){
            int p1 = getPosition(c[0]);
            vertextLists[p1].add(c[1]);
            int p2 = getPosition(c[1]);
            vertextLists[p2].add(c[0]);
        }
    }

    //根据顶点名称获取链表下标
    private int getPosition(char ch) {
        for (int i = 0; i < size; i++) {
            if (vertextLists[i].ch == ch) {
                return i;
            }
        }
        return -1;
    }

    //遍历输出邻接表
   public void print() {
       for (int i = 0; i <size ; i++) {
           Vertex temp = vertextLists[i];
           while (temp != null) {
               System.out.print(temp.ch+" ");
               temp = temp.next;
           }
           System.out.println();
       }
   }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        char[][] edges = new char[][]{
                {'A','C'}, //A和C之间有关系
                {'A','D'}, //A和D之间有关系
                {'A','F'}, //A和F之间有关系
                {'B','C'},
                {'C','D'},
                {'E','G'},
                {'D','G'},
                {'I','J'},
                {'J','G'},
                {'E','H'},
                {'H','K'}};
        ListNDG pG = new ListNDG(vexs, edges); //edges 两个边的关系
        pG.print();

    //    A C D F  A有三个边分别是CDF
    //    B C B节点有1个边 C
    }
}
