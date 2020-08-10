package com.leesin.arithmetic.sort;

import java.util.Arrays;

/**
 * @description: 希尔排序 (插入排序移动的次数很多，插入排序的升级) 也是一种插入排序
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 21:51
 * @modified By:
 */

// 缩小增量排序 小的数快速的到前面、大的数快速的到后面，避免特别小的数在最后，需要移动很多次{9 8 8 7 7 1} 1想移动到第一个要很久

//每组进行插入排序 数组/2  数组/2/2 ...
public class 希尔 {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        //十个数据经历了三轮
        int count = 1;
        //【第一个层就是为了规定的三次 5 2 1 修改步长的】
        //【从第1/2的时候开始】
        //变化的其实就是 for (int i = 5; 这个5 2 1 ，所以 把三次循环抽出来
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //【第二层根据步长从，第5个一直到最后】
            for (int i = gap; i < arr.length; i++) {
                //【第三层 根据每个步长的数组，往前减去步长，两个数作比较】
                //往前找5个步长 遍历各组中所有的元素（共5组，每组有2个元素（其他场景可能更多）），步长5
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的哪个元素，说明交换
                    // if (arr[i] < arr[j]) {//按照自己的理解写了
                    if (arr[j] > arr[j + gap]) {//等效于if (arr[i] < arr[j]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("第"+(++count)+"轮：" + Arrays.toString(arr));
        }

        /*//第一轮 10/2 = 5 分成了5组 步长也就是5   从0-5这个开始 从5一直到后面这么多次
        for (int i = 5; i < arr.length; i++) {
            //往前找5个步长 遍历各组中所有的元素（共5组，每组有2个元素（其他场景可能更多）），步长5
            for (int j = i - 5; j >= 0; j -= 5) {
                //如果当前元素大于加上步长后的哪个元素，说明交换
                if (arr[j] > arr[j + 5]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("第一轮：" + Arrays.toString(arr));

        //第二轮 5/2 = 2 分成了2组 步长也就是2
        for (int i = 2; i < arr.length; i++) {
            //往前找5个步长 遍历各组中所有的元素（共5组，每组有2个元素（其他场景可能更多）），步长5
            for (int j = i - 2; j >= 0; j -= 2) {
                //如果当前元素大于加上步长后的哪个元素，说明交换
                if (arr[j] > arr[j + 2]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("第二轮：" + Arrays.toString(arr));

        //第三轮 2/2 = 1 分成了1组 步长也就是1
        for (int i = 1; i < arr.length; i++) {
            //往前找5个步长 遍历各组中所有的元素（共5组，每组有2个元素（其他场景可能更多）），步长5
            for (int j = i - 1; j >= 0; j -= 1) {
                //如果当前元素大于加上步长后的哪个元素，说明交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第二轮：" + Arrays.toString(arr));
*/
    }
}
