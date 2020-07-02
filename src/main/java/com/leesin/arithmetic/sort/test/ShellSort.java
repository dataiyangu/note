package com.leesin.arithmetic.sort.test;

import com.leesin.arithmetic.sort.Bubble;

import java.util.Arrays;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 11:23
 * @modified By:
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1,3,6,1,-1,89};
        for (int temp = arr.length / 2; temp > 0; temp /= 2) {
            for (int i = temp; i < arr.length ; i++) {
                for (int j = i-temp; j >=0 ; j = j-temp) {
                    if (arr[i]<  arr[j]) {
                        Bubble.swap(arr,i,j);
                    }

                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
