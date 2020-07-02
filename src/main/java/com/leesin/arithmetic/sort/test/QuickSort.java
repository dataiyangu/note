package com.leesin.arithmetic.sort.test;

import java.util.Arrays;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 12:36
 * @modified By:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[], int left, int right) {
        int pivote = arr[(left + right) / 2];
        int l = left;
        int r = right;

        while (l < r) {
            while (arr[l] < pivote) {
                l++;
            }
            while (arr[r] > pivote) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivote) {
                r--;
            }
            if (arr[r] == pivote) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (l < right) {
            quickSort(arr, l, right);
        }
        if (r > left) {
            quickSort(arr,left,r);
        }
    }
}
