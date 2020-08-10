package com.leesin.arithmetic.sort.test;

import java.util.Arrays;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 14:18
 * @modified By:
 */
public class 归并 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5, 3, 4, -2};
        //这里
        int[] swap = new int[arr.length];
        sort(arr, 0, arr.length - 1,swap);
        System.out.println(Arrays.toString(arr));
    }
    public static void  sort(int[] arr,int left,int right,int [] swap) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr,left,mid,swap);
            sort(arr, mid + 1, right,swap);
            mergeSort(arr,left,right,mid,swap);
        }
    }

    public static void mergeSort(int[] arr, int left, int right, int mid, int[] swap) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <=mid&&j<=right) {
            if (arr[i] <= arr[j]) {
                swap[t] = arr[i];
                i++;
                t++;
            } else if (arr[i] > arr[j]) {
                swap[t] = arr[j];
                j++;
                t++;
            }
        }
        while (i <= mid) {
            swap[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            swap[t] = arr[j];
            j++;
            t++;
        }
        int stepLeft = left;
        int t1 = 0;
        while (stepLeft <= right) {
            arr[stepLeft] = swap[t1];
            stepLeft++;
            t1++;
        }
    }
}
