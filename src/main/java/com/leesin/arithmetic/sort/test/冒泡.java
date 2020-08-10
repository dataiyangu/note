package com.leesin.arithmetic.sort.test;

import com.leesin.arithmetic.sort.Swap;

import java.util.Arrays;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 10:35
 * @modified By:
 */
public class 冒泡 {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] < arr[j + 1]) {
                    Swap.swap(arr, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
