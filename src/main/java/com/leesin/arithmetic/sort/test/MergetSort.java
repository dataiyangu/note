package com.leesin.arithmetic.sort.test;

import java.util.Arrays;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 14:18
 * @modified By:
 */
public class MergetSort {
    public static void main(String[] args) {
        int arr[] = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        partAndMerge(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void partAndMerge(int [] arr,int left,int right,int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            partAndMerge(arr, left, mid, temp);
            partAndMerge(arr,mid+1,right,temp);
            merge(arr, left, mid, right, temp);
        }

    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;
        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                l++;
                t++;
            } else {
                temp[t] = arr[r];
                r++;
                t++;
            }
        }

        while (l <= mid) {
            temp[t] = arr[l];
            l++;
            t++;
        }
        while (r <= right) {
            temp[t] = arr[r];
            r++;
            t++;
        }
        int lefttmp= left;
        t = 0;
        while (lefttmp <= right) {
            arr[lefttmp] = temp[t];
            lefttmp++;
            t++;
        }
    }
}
