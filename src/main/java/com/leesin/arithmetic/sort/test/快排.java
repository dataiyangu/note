package com.leesin.arithmetic.sort.test;

import java.util.Arrays;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 12:36
 * @modified By:
 */
public class 快排 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 3, -1, 9, 5, 4};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int mid = (left + right) / 2;
        while (l < r) {
            while (arr[l] < arr[mid]) {
                l++;
            }
            //这里是>
            while (arr[r] > arr[mid]) {
                r--;
            }
            if (l >= r) {
                return;
            }
            int swap = arr[l];
            arr[l] = arr[r];
            arr[r] = swap;
            if (arr[l] == arr[mid]) {
                r--;
            }
            if (arr[r] == arr[mid]) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            sort(arr, left, r);
        } else if (l < right) {
            sort(arr, l, right);
        }
    }

}
