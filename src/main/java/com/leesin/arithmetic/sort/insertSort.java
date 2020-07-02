package com.leesin.arithmetic.sort;

import java.util.Arrays;

/**
 * @description: 插入排序
 * @author: Leesin Dong
 * @date: Created in 2020/7/1 0001 21:34
 * @modified By:
 */
public class insertSort {
    //无序表中的内容插入到前面的有序表中
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1,1,-1,89};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        /*可以直接这么写
        //从第i个开始往前插，i【待插入】，一直到最后一个都往前插
        * */
        //总结：从第1个开始往前插
        //【外层从哪个开始插入【待插入的元素】】
        //【i是第i个是待插入从1开始,arr[1] 要往前插，arr[2]要往前插，arr[3]要往前插】
        for (int i = 1; i < arr.length; i++) {
            //【内层：往前比不对就插入】
            for (int j = i; j > 0; j--) {
                //【arr[j-1] 是要往前插入的地方  arr[1]往arr[0]插,arr[2]往arr[1] arr[0]插，arr[3]往arr[2]、arr[1]、arr[0]插】
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }
        }

        //还是length次，但是这里不减一，因为从1开始的
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];//定一个待插入的数 34
            int insertIndex = i-1;//即arr[1]的前面的数的下标，往前面插
            //【递归往前插】
            //1. insertIndex > 0 保证给insertVal找出入位置不越界
            //2. insertValue > arr[insertIndex],待插入的数，还没有找到插入的位置，需要插入到前面
            //3. 就需要将arr[insertIndex] 后移 【类似递归后移】
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                //没有交换，而是直接把 如果前面大，把大值直接给了后面，相当于交换了，
                //【核心就这句话，让大的递归往后移动，然后while移动完，下面给最小的赋值一次】
                arr[insertIndex + 1] = arr[insertIndex];//{101, 34, 119, 1}-》{101, 101, 119, 1},34没有丢，int insertValue = arr[1];中已经保存了
                insertIndex--; //需要34再跟101前面的数进行比较
            }
            //当退出while循环时，说明插入的位置找到，在insertIndex+1的位置 假如{101, 342, 119, 1}，经过一轮342在第二个位置
            //经过上面的while，index已经变成了index--了，所以这里需要真实的index，所以index++
            //【这里重新赋值，因为index经过上面变成了index--多减了一次，所以这里++，变成本身的。】
            arr[insertIndex + 1] = insertValue;

            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));
        }


      /*  //第1轮 {101, 34, 119, 1}
        //定一个待插入的数 34
        int insertValue = arr[1];
        int insertIndex = 1-1;//即arr[1]的前面的数的下标，往前面插
        //1. insertIndex > 0 保证给insertVal找出入位置不越界
        //2. insertValue > arr[insertIndex],待插入的数，还没有找到插入的位置，需要插入到前面
        //3. 就需要将arr[insertIndex] 后移
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];//{101, 34, 119, 1}-》{101, 101, 119, 1},34没有丢，int insertValue = arr[1];中已经保存了
            insertIndex--; //需要34再跟101前面的数进行比较
        }
        //当退出while循环时，说明插入的位置找到，在insertIndex+1的位置 假如{101, 342, 119, 1}，经过一轮342在第二个位置
        arr[insertIndex + 1] = insertValue;

        System.out.println("第1轮插入");
        System.out.println(Arrays.toString(arr));

        //第2轮 {101, 34, 119, 1}
        //定一个待插入的数 119
         insertValue = arr[2];
         insertIndex = 2-1;//即arr[1]的前面的数的下标，往前面插
        //1. insertIndex > 0 保证给insertVal找出入位置不越界
        //2. insertValue > arr[insertIndex],待插入的数，还没有找到插入的位置，需要插入到前面
        //3. 就需要将arr[insertIndex] 后移
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];//{101, 34, 119, 1}-》{101, 101, 119, 1},34没有丢，int insertValue = arr[1];中已经保存了
            insertIndex--; //需要34再跟101前面的数进行比较
        }
        //当退出while循环时，说明插入的位置找到，在insertIndex+1的位置 假如{101, 342, 119, 1}，经过一轮342在第二个位置
        arr[insertIndex + 1] = insertValue;

        System.out.println("第2轮插入");
        System.out.println(Arrays.toString(arr));



        //第3轮 {101, 34, 119, 1}
        //定一个待插入的数 119
        insertValue = arr[3];
        insertIndex = 3-1;//即arr[1]的前面的数的下标，往前面插
        //1. insertIndex > 0 保证给insertVal找出入位置不越界
        //2. insertValue > arr[insertIndex],待插入的数，还没有找到插入的位置，需要插入到前面
        //3. 就需要将arr[insertIndex] 后移
        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];//{101, 34, 119, 1}-》{101, 101, 119, 1},34没有丢，int insertValue = arr[1];中已经保存了
            insertIndex--; //需要34再跟101前面的数进行比较
        }
        //当退出while循环时，说明插入的位置找到，在insertIndex+1的位置 假如{101, 342, 119, 1}，经过一轮342在第二个位置
        arr[insertIndex + 1] = insertValue;

        System.out.println("第3轮插入");
        System.out.println(Arrays.toString(arr));*/
    }
}
