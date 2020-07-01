package com.leesin.arithmetic.sort;

/**
 * @description: 插入排序
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 21:34
 * @modified By:
 */
public class Charu {
    //从第二个开始，比前面的小就插入到前面
    //第二次循环：然后从第三个开始，比第二个小，插到第二个前面，然后比第一个小，插入到第一个前面

    //找到一个就插入，停止本次内层循环了
    public static void main(String[] args) {
        int [] arr =  {7, 5, 3, 2, 4};
        for (int i = 1; i < arr.length; i++) {
            //j>0闹着玩的，本身不需要条件，下面有break退出
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }

        }
        ZZZZZ.sout(arr);
    }
}
