package com.leesin.arithmetic.search.test;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 15:59
 * @modified By:
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1234};
        int index = search(arr, 0, arr.length - 1, 8);
        System.out.println(index);
    }

    public static int search(int[] arr, int left, int right, int findval) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midval = arr[mid];
        if (findval < midval) {
            return search(arr, left, mid - 1, findval);
        } else if (findval > midval) {
            return search(arr, mid + 1, right, findval);
        } else {
            return mid;
        }
    }
}
