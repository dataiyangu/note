package com.leesin.arithmetic.search.test;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 15:59
 * @modified By:
 */
public class 二分法 {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1234};
        int index = sort(arr, 0, arr.length, 1);
        System.out.println(index);
    }

    public static int sort(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        } else {
            int mid = (left + right) / 2;
            if (arr[mid] > value) {
                return sort(arr, left, mid-1, value);
            } else if (arr[mid] < value) {
                return sort(arr, mid + 1, right, value);
            } else {
                return mid;
            }
        }
    }
}
