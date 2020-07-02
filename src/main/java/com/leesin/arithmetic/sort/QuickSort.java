package com.leesin.arithmetic.sort;

import java.util.Arrays;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/2 0002 11:37
 * @modified By:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70,-1,900,4561};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //【这个是 有两个索引，中间的在最中间，两遍的索引往中间遍历】
    //传入最左边的索引、最右边的索引
    public static void quickSort(int[] arr, int left, int right) {
        //l 和 r作为这里的能够动的指针，left和right作为传下来固定的，可以递归的时候用left、right固定的
        int l = left;//左下标
        int r = right;//右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        //只要左边的索引还小于右边的索引，说明还有数没有处理完，直到两个重合或者>说明处理完了
        //while循环的目的：
        //让比pivot小的放到左边，比pivot大的放到右边
        //【这里就是交换的】
        while (l < r) {
            //【左边和右边分别找到一个 比 pivote大的  一个比pivote小的，然后交换】
            //在pivot的左边一直找，直到找到一个大于等于pivot大的，
            // 就退出，此时的l就会变成指向比pivot大的下标
            //目的：让l指向比pivot大的
            while (arr[l] < pivot) {
                l += 1;//l从最左边开始的
            }
            //在pivot的右边一直找，直到找到一个小于等于pivot的，就退出
            //目的：让r指向比pivot小的
            while (arr[r] > pivot) {
                r -= 1;//r从最右边开始的   【这里是从右往左】
            }
            //如果l>=r 说明pivot的左右两边的值，已经按照左边全部是小于等于pivot的值，右边全是大于等于pivot的值
            //满足这个条件退出
            //如果找到了左边大的、右边小的，但是已经左指针大于等于右指针，说明已经处理完了，不用处理了，直接退出（满足while了都）
            if (l >= r) {
                //说明找到了
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //【错过相等的，避免 左边后者右边相等的那个一直进来】
            //交换 后的 arr[l]其实就是交换前的arr[r]，说明原来的 arr[r]==pivot，
            //说明上面的第二个while的地方，直接出来了，r没有-=1,这里补一刀，不然，后面r永远停留在这里了
            if (arr[l] == pivot) {
                r -= 1;//相等的话，没有必要再比较右边
            }
            //同上
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //不把l 和 r错开 就一直在这里做这个事情，因为上面的条件是满足的，退不出来
        //l已经和r相等了，结束递归，否则，下面一直递归下去，堆栈溢出，可以看出递归条件永远在递归调用的上面
        //这里没有直接return，其实一样的感觉，因为下次递归，到上面的while还是出来

        //【上面出了循环，说明相等或者直接错开了，相等就错开】
        if (l == r) {
            l += 1;
            r -= 1;
            //直接retrun也可以，作为迭代出去的条件
        }

        //先向左还是先向右，顺序不固定，随意
        //【下面就是递归的】
        //因为上面错了一位。
        //【left xxx  r pivote l xxx right】
        //【l  xxx    r】 -> 【r xxx  l】 ，r最终相当于从右往左扫描了一遍
        //向左递归  0 左边的变成有序的
        // left>=r是出来的的条件  因为r一直递归不停的往左，最后<left就不能再递归了
        if (left < r) {
            quickSort(arr,left,r);//右边按照r走，因为上面while循环完了的时候r已经发生变化了，
        }
        //向右递归
        //方式是递归，右边都小于他了死循环
        if (right > l) {
            quickSort(arr,l,right);
        }


    }
}
