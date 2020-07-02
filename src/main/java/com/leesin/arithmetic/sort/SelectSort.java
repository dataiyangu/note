package com.leesin.arithmetic.sort;

import java.util.Arrays;

/**
 * @description: 选择排序
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 20:57
 * @modified By:
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
    }

    public static void selectSort(int[] arr) {

        /*其实可以直接写成
         * //外层控制循环轮数
         * //【arr[i] 不变，去和后面的依次比较，需要交换就交换】
         * */
        //总结：从第0个开始往后比
        //【外层：后面的跟哪个比】
        //【第0个是最小值的初始值，后面的都跟0比，下次是1】
        for (int i = 0; i < arr.length - 1; i++) {
            //【内层：往后比，不对就改变】
            //【第0个最小，从第1个开始往前比】 为什么到arr，从i+1一直比到最后一个
            for (int j = i + 1; j < arr.length; j++) {//内层控制每轮循环的次数
                //【第0个 跟后面的每一个比较】
                if (arr[i] > arr[j]) { // 拿每次循环的第一个元素i依次与后边的每个元素j比较
                    // 交换位置
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        //时间复杂度(O(n^2))

        //因为只有n-1轮
        for (
                int i = 0;
                i < arr.length - 1; i++) {
            int minIndex = i;
            //这个相当于一个temp，在内层循环找到先给temp，在外层交换两个值。
            int min = arr[i];
            //假定的最小值跟后面的进行比较，从J+1开始比较，也就是第一个后面的
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {//说明假定的最小值不是最小的 //面试官：从大到小呢？ > 改为 <
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                    if (minIndex != i) {
                        //此时minindex已经到了后面了
                        arr[minIndex] = arr[i];
                        arr[i] = min;
                    }
                }
            }
            //经过上面，最小值的索引可能已经到后面的，让他到前面
            //将最小值放到arr[0]，即交换
            //【老师是这么写的，但是经过测试，直接写在里面一样的。】
            // if (minIndex != i) {
            //     //此时minindex已经到了后面了
            //     arr[minIndex] = arr[i];
            //     arr[i] = min;
            // }
            System.out.println("第" + (i + 1) + "轮后");
            System.out.println(Arrays.toString(arr));
        }



        /*
        //使用逐步推到的方式来，讲解选择排序
        //第1轮
        //原始数组：101,34,119,1
        //第一轮排序：1,34,119,101
        //算法  简单---》再复杂，就是可以把一个复杂的算法拆分成简单的问题-》逐步解决

        //第一次假定第一个是最小的
        //确定最小的索引
        int minIndex = 0;
        int min = arr[0];
        //假定的最小值跟后面的进行比较，从J+1开始比较，也就是第一个后面的
        for (int j = 0 + 1; j < arr.length; j++) {
            if (min > arr[j]) {//说明假定的最小值不是最小的
                min = arr[j];//重置min
                minIndex = j;//重置minIndex
            }
        }
        //经过上面，最小值的索引可能已经到后面的，让他到前面
        //将最小值放到arr[0]，即交换
        //因为可能位置没有变，就不需要交换
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        //本质用下面的也可以，就是交换
        // int swap = arr[0];
        // arr[0] = arr[minIndex];
        // arr[minIndex] = swap;

        System.out.println("第1轮后");
        System.out.println(Arrays.toString(arr)); //把1放在了最前面

        //第2轮
         minIndex =1;
         min = arr[1];
        //假定的最小值跟后面的进行比较，从J+1开始比较，也就是第一个后面的
        for (int j = 1 + 1; j < arr.length; j++) {
            if (min > arr[j]) {//说明假定的最小值不是最小的
                min = arr[j];//重置min
                minIndex = j;//重置minIndex
            }
        }
        //经过上面，最小值的索引可能已经到后面的，让他到前面
        //将最小值放到arr[0]，即交换
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        //本质用下面的也可以，就是交换
        // int swap = arr[0];
        // arr[0] = arr[minIndex];
        // arr[minIndex] = swap;

        System.out.println("第2轮后");
        System.out.println(Arrays.toString(arr)); //把1放在了最前面 //[1, 34, 119, 101]

        //第3轮
        minIndex =2;
        min = arr[2];
        //假定的最小值跟后面的进行比较，从J+1开始比较，也就是第一个后面的
        for (int j = 2 + 1; j < arr.length; j++) {
            if (min > arr[j]) {//说明假定的最小值不是最小的
                min = arr[j];//重置min
                minIndex = j;//重置minIndex
            }
        }
        //经过上面，最小值的索引可能已经到后面的，让他到前面
        //将最小值放到arr[0]，即交换
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
        //本质用下面的也可以，就是交换
        // int swap = arr[0];
        // arr[0] = arr[minIndex];
        // arr[minIndex] = swap;

        System.out.println("第2轮后");
        System.out.println(Arrays.toString(arr)); //把1放在了最前面 //[1, 34, 101, 119]
        */


    }
}
