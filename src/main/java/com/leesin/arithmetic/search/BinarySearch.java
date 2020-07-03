package com.leesin.arithmetic.search;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 15:42
 * @modified By:
 */

//注意：使用二分查找的前提：该数组是有序的
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1234};
        int index = binarySearch(arr, 0, arr.length - 1, 0);
        System.out.println(index);
    }

    /**
     * @description:
     * @param: arr 数组
     * @param: left 左边的索引
     * @param: right 右边的索引
     * @param: findVal 要查找的值
     * @return: int 如果找到就返回下标，如果没有找到就返回-1
     **/
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        //【left在最左，right在最右】--->【right-----left】
        //当left>right时，说明递归整个数组，但是没有找到，结束递归，一直递归下去，会堆栈溢出。
        if (left > right) {
            return -1;
        }

        //计算机中的中间值 【如果中间两个都是中间值，取左边的】
        int mid = (left + right) / 2;//拿到中间的下标
        int midVal = arr[mid];//拿到中间的值
        if (findVal > midVal) {//如果要找的值>中间的值，向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {//向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
