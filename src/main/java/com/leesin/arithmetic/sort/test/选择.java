package com.leesin.arithmetic.sort.test;

import com.leesin.arithmetic.sort.Swap;

import java.util.Arrays;

/**
 * @description: 选择排序
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 10:20
 * @modified By:
 */
public class 选择 {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, 100, 20, 40};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[i] > arr[j]) {
                    Swap.swap(arr, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
