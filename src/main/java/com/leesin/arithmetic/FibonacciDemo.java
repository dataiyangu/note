package com.leesin.arithmetic;

/**
 * @description:斐波那契算法
 * @author: Leesin.Dong
 * @date: Created in 2020/3/24 22:56
 * @version: ${VERSION}
 * @modified By:
 */
public class FibonacciDemo {
    private static final int HASH_INCREMENT = 0x61c88647;

    public static void main(String[] args) {
        magicHash(16);
        magicHash(32);
        // 7 14 5 12 3 10 1 8 15 6 13 4 11 2 9 0
        // 7 14 21 28 3 10 17 24 31 6 13 20 27 2 9 16 23 30 5 12 19 26 1 8 15 22 29 4 11 18 25 0
    //最后的数字均衡的分布再容量范围之内，并且不会重复
    }


    private static void magicHash(int size) {
        int hashCode = 0;
        for (int i = 0; i < size; i++) {
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            System.out.print((hashCode&(size-1))+" ");
        }
        System.out.println();
        //
        hashCode = 3 * HASH_INCREMENT + HASH_INCREMENT;
        System.out.print((hashCode&(size-1))+" ");

        System.out.println();

    }
}
