package com.leesin.arithmetic.sort.test;

import com.leesin.arithmetic.sort.Swap;

import java.util.Arrays;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 11:23
 * @modified By:
 */
public class 希尔 {
    /*
    * 就是插入排序，外面多一个步长，插入排序的变量变成步长
    * 写法基本和插入排序一样的
    * */
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1,3,6,1,-1,89};
        for (int step = arr.length/2; step >0 ; step = step/2) {
            for (int i = step; i <arr.length ; i++) {
                for (int j =i-step ; j >=0 ; j--) {
                    if (arr[j] > arr[j + step]) {
                        Swap.swap(arr,j,j+step);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
