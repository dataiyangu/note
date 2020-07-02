package com.leesin.arithmetic.sort.test;

import com.leesin.arithmetic.sort.Bubble;

import java.util.Arrays;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 10:35
 * @modified By:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if (arr[j] < arr[j + 1]) {
                    Bubble.swap(arr,j,j+1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
