package com.leesin.arithmetic.sort;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/29 0029 15:51
 * @modified By:
 */
public class Swap {
    /*
     * 封装一个通用交换的方法
     * */
    public static void swap(int[] arr ,int a,int b) {
        int swap = arr[a];
        arr[a]= arr[b];
        arr[b] = swap;
    }
}
