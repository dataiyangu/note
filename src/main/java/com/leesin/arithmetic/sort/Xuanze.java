package com.leesin.arithmetic.sort;

/**
 * @description: 选择排序
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 20:57
 * @modified By:
 */
//选择排序从小到大排序：一开始从0~n-1区间上选择一个最小值，将其放在位置0上，
// 然后在1~n-1范围上选取最小值放在位置1上。重复过程直到剩下最后一个元素，数组即为有序。

//说明：将i前面的数据看成一个排好的队列，i后面的看成一个无序队列。每次只需要找无需的最小值，做替换

//总是一个区间最小值放在最前面，区间往后缩小
 //   1    2    3
//    min
//第一个是min，和后面一个开始比较
public class Xuanze {
    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 4};
        //这里的i是从第 i 个开始和后面的比
        for (int i = 0; i < arr.length; i++) {
            //把第一个当做最小的
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            int swap = arr[i];
            arr[i] = arr[index];
            arr[index] = swap;
        }
        ZZZZZ.sout(arr);
    }
}
