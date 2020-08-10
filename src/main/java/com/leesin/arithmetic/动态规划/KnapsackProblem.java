package com.leesin.arithmetic.动态规划;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/7 0007 8:34
 * @modified By:
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000};//物品的价值 这里的val[i]，就是前面将的v[i]
        int m = 4;//背包的重量
        int n = val.length;//物品的个数

        //创建二维数组
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        //为了记录放入商品的状况，我们定义一个二维数组
        int[][] path = new int[n + 1][m + 1];

        //以下两个for循环可以不处理
        //初始化第一行和第一列，这里在本程序中，可以不去处理，因为默认为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;//将第一列设置为0
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;//将第一行设置为0
        }

        //输出一下v 看看目前的情况
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //根据前面得到的公式来动态规划处理
        for (int i = 1; i < v.length; i++) {//不处理第一行 i是从1开始的
            for (int j = 1; j < v[0].length; j++) {//不处理第一列,j是从1开始的
                if (w[i - 1] > j) {//因为我们的程序i是从1开始的，因此原来公式中w[i]修改成w[i-1]
                    v[i][j] = v[i - 1][j];
                } else {
                    //说明：
                    //因为我们的i从1开始的，因此公式需要调整成
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1]+v[i-1] [j- w[i - 1]])
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1]+v[i-1] [j- w[i - 1]]);
                    //为了记录商品存放到背包的情况，我们不能简单的使用上面的公式，需要使用if-else来体现公式
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //把当前的情况记录到path
                        //只需要记录这里，因为这里是最优的
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出一下v 看看目前的情况
        System.out.println();
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //输出最后我们是放入的哪些商品

        //不用这个
        //遍历path，这样的输出会把所有的放入情况都得到（因为上面的v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]，中间的也是城里的，都path[i][j]=1了）
        //其实我们只需要最后的放入
        // System.out.println("==============");
        // for (int i = 0; i < path.length; i++) {
        //     for (int j = 0; j < path[i].length; j++) {
        //         if (path[i][j] == 1) {
        //             //因为上面存入path的for循环，i是从1开始的，所以这里不需要+1，i是第一个商品、第几行：吉他、音响的意思
        //             System.out.printf("第%d个商品放入到背包\n", i);
        //         }
        //     }
        // }

        //动脑筋
        int i = path.length - 1;//行的最大下标
        int j = path[0].length - 1;//列的最大下标

        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n",i);
                j -= w[i - 1];//定位到w[i-1]的位置 ，即表格中的音响、1榜位置
            }
            i--;//定位到w[i-1]的位置 ，即表格中的音响、1榜位置
        }
    }
}
