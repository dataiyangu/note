package com.leesin.arithmetic.sort;

import java.util.Arrays;

/**
 * @description:冒泡排序
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 20:00
 * @modified By:
 */
//每次从0开始，两两比较，最大的跑到最后，下次最后的不进行比较
//
public class Bubble {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
        int temp = 0;

//下面是分析过程
/*      //第一趟排序就是将最大的数排在最后
        //第一个趟排序需要四次比较（五个数两两比较是四次）
        for (int j = 0; j < arr.length - 1; j++) {
            //如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第一趟排序后的数组");
        System.out.println(Arrays.toString(arr));//[3, -1, 9, -2, 10]10最后的位置

        //第二趟排序就是将第二大的数排在倒数第二位
        //第二趟比较了三次（第一次排好的最大的数不再参与比较）
        for (int j = 0; j < arr.length - 1 - 1; j++) {
            //如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));//[-1, 3, -2, 9, 10]9倒数第二的位置

        //第三趟排序就是将第三大的数排在倒数第三位
        //第三趟比较了二次（第一、二次排好的最大的数不再参与比较）
        for (int j = 0; j < arr.length - 1 - 2; j++) {
            //如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));//[-1, -2, 3, 9, 10]

        //第四趟排序就是将第四大的数排在倒数第四位
        //第四趟比较了次（第一、二、三次排好的最大的数不再参与比较）
        for (int j = 0; j < arr.length - 1 - 3; j++) {
            //如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));//[-2, -1, 3, 9, 10]
*/
        //不需要进行第五次排序，因为一共五个数据，已经确定了四个数的位置，第五个就不需要了

        //四个for循环除了for j < arr.length - 1 - 3 这里的3不一样，其余的都是一样的，所以可以把这个for循环包起来
        //四个for循环都是重复代码
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟排序后的数组");
            System.out.println(Arrays.toString(arr));
        }
    }
}
// 时间复杂度O(n^2)
