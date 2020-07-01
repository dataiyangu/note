package com.leesin.arithmetic.greph;

/**
 * @description: 邻接矩阵实现的无向图
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 11:59
 * @modified By:
 */
public class MatrixNDG {
    //基本数据结构：二维数组

    int size;//图顶点个数
    char[] vertexs;//图顶点名称
    int[][] matrix;//图关系矩阵

    //构造方法进行初始化
    public MatrixNDG(char[] vertexs, char[][] edges) {
        size = vertexs.length;
        matrix = new int[size][size];//设定图关系矩阵的大小
        this.vertexs = vertexs;

        for (char[] c : edges) {//设置矩阵制  根据两个边的关系，确定两个节点的下标
            int p1 =  getPosition(c[0]);//根据顶点名称确定对应矩阵下标
            int p2  = getPosition(c[1]);

            //因为是无向图，所以有两个方向，所以把两个方向全部赋值成1
            matrix[p1][p2] = 1;//无向图，在两个对称位置存储
            matrix[p2][p1] = 1;
        }
    }
    //图的遍历输出
    public void  print(){
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    //根据顶点名称获取对应的矩阵下标
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++)
            if (vertexs[i]==ch)
                return i;
        return -1;
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
        MatrixNDG pG = new MatrixNDG(vexs, edges); //edges 两个边的关系
        pG.print();
    }

    /**
     * @description: 深度优先算法
     * @name: DFS
     * @param: x 下标
     * @param: y 矩阵坐标
     * @param: beTraversed 一个数组记录节点是否被访问到了
     * @return: void
     * @date: 2020/7/1 0001 13:44
     * @auther: Administrator
     **/
    private void DFS(int x,int y,boolean[] beTraversed) {
        //y是char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'};
        while (y <= size - 1) {
            if (matrix[x][y] != 0 && beTraversed[y] ==false) {//!=0说明有边 && 没有访问过该节点
                System.out.println(vertexs[y]+" ");//输出这个节点
                beTraversed[y] = true;//标注为已经访问
                DFS(y,0,beTraversed);//以该节点为起始节点，继续递归调用
            }
            y++;//便于循环
        }
    }
    /**
     * @description: 为了方便调用，封装一个方法，把一些变量初始化一下
     * @name: DFS
     * @param:
     * @return:
     * @date: 2020/7/1 0001 13:53
     * @auther: Administrator
    **/
    public void  DFS() {
        boolean[] beTraversed = new boolean[size]; //初始化boolean数组，记录该节点是否被访问到
        //自动赋值全是false
        System.out.println(vertexs[0]+" ");//把第一个节点先输出
        // 然后进行标记
        beTraversed[0] = true;
        //最后调用下面的方法
        DFS(0,0,beTraversed);
    }
}
