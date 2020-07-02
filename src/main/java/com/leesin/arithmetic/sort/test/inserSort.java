package com.leesin.arithmetic.sort.test;

import com.leesin.arithmetic.sort.Bubble;

import java.util.Arrays;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 9:50
 * @modified By:
 */
public class inserSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};

        for (int i = 1; i <arr.length ; i++) {
            for (int j = i; j >0 ; j--) {
                if (arr[j] < arr[j--]) {
                    Bubble.swap(arr,j,j--);
                }
            }
        }
        System.out.println(Arrays.toString(arr));

        // int i = 2;
        // // int a = --i;
        // int a = i - 1;
        // System.out.println(a);
    }

}
