package com.leesin.arithmetic.sort;

import java.util.Arrays;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 13:10
 * @modified By:
 */
//合并n-1次
public class MergetSort {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        int temp[] = new int[arr.length];//归并排序需要一个额外的空间
        partAndMerge(arr,0,arr.length-1,temp);
        System.out.println("归并排序后："+ Arrays.toString(arr));
    }

    /**
     * @description: 分+合的方法 谁分到最里面谁先合并，然后再依次合并出来
     * @param: arr
     * @param: left
     * @param: right
     * @param: temp
     * @return: void
    **/
    //注意这个数组自始至终一直都是没有分开的，都是在操作这个数组，并不是像图里面画的一样
    public static void partAndMerge(int[] arr, int left, int right, int[] temp) {
        if (left < right) {// left索引<right索引
            //把中间的索引拿到    【left...mid】【mid+1...right】
            int mid = (left + right) / 2; //中间的索引
            //向左递归进行分解  执行完，已经分解完并且合并完（排序好了数组左半部分）
            partAndMerge(arr, left, mid, temp);
            //向右递归进行分解  执行完，已经分解完并且合并完（排序好了数组右半部分）
            partAndMerge(arr,mid+1,right,temp);
            // 上面两个分解完的 并且合并完，最后两个排好序的进行合并（将左右进行合并）
            merge(arr,left,mid,right,temp);

            //总结：分开+合并的迭代 先看最外层也就是图中的
        }
    }

    /**
     * @description:合并的方法
     * @param: arr 排序的原始数组
     * @param: left 左边有序序列的初始索引 left从哪个索引开始
     * @param: mid 中间索引  mid右边有序的前面的位置
     * @param: right 右边索引
     * @param: temp 中转数组
     * @return: void
     **/
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        System.out.println("合并");
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid + 1;//初始化j，右边有序序列的初始索引  记住这两个是索引
        int t = 0;//指向temp数组的当前索引（temp也需要一个索引记录排序到哪里了）

        //（一）
        //先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一遍处理完毕为止
        while (i <= mid && j <= right) {        //说明还要继续做 有一个超了，说明左边或者右边超过了，去第二步，将另一边剩下的全部移动过去
            //如果左边有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边到当前元素拷贝到temp数组
            //然后t++,i++ 往后移一下
            if (arr[i] <= arr[j]) {//如果左边有序序列的当前元素，小于右边有序序列的当前元素
                temp[t] = arr[i];//把左边的拷贝到数组中去
                t += 1;//t是 temp的指针
                i += 1;//i是左边数组指针
            } else {//反之将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //（二）
        //把剩余数据的一边的数据一次全部填充到temp
        while (i <= mid) {//说明左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {//右边有剩余
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //（三）
        //将temp数组的元素拷贝到arr
        //不能理解成每次都把temp拷贝回去，因为只有最后一次temp才是满的，第一次合并只有两个，不是每次都拷贝八个
        // 48 57    01 23
        // 4857    03
        // 4857 xxxx 07
        t = 0;//记录temp
        //这里是指针
        int tempLeft = left;//记录数组左边索引 因为左边索引需要变，右边索引不需要变右边就不用赋值为新的了
        //第一次合并templeft:0 right=1 第一次合并 templeft:2 right=3第三次合并 templeft:0 right=3
        //最后一次templeft:0 right=7
        System.out.println("tempLeft = "+tempLeft+"right = "+right);
        //【xxx xxx xxx  xxx】 中间层合并的时候，left不是1，还可能是后面的数字
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;//temp记录的+1
            tempLeft += 1;//数组左边索引+1
        }
    }
}
