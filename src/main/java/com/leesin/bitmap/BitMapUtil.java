package com.leesin.bitmap;

/**
 * @author: dongxueyuan
 * @date: Created in 2020/10/26 5:57 下午
 */
public class BitMapUtil {

    public static void main(String[] args) {
        int bit = 0;
        long num = 1 << bit;
        erjinzhi(num);
        long bitMap = 0;
        bitMap = com.yupaopao.platform.common.utils.BitMapUtil.getBitMap(bitMap,0, 1);
        erjinzhi(bitMap);

        //return (bitMap & num) == 0 ? 0 : 1;
    }

    /**
     * 获取bitMap某一位的值
     *
     * @param bitMap bitMap
     * @param bit    位
     * @return value
     */
    public static int getBitValue(long bitMap, int bit) {
        long num = 1 << bit;
        return (bitMap & num) == 0 ? 0 : 1;
        //101
        //010   看第二位
        // 高位自己过滤成0，中间的被bitmap过滤成0，低位自己过滤成0，所以最终会是0
    }

    public static void erjinzhi(long l) {
        System.out.println("二进制输出: " + Long.toBinaryString(l));
    }

    /**
     * 计算bitMap  （初始化bitmap的时候用）
     *
     * @param bitMap 原bitMap
     * @param bit    位
     * @param value  值
     * @return bitMap
     */
    // test: bit = 0,value = 1
    public static long getBitMap(long bitMap, int bit, int value) {
        // bitMap 0
        // result 0
        long result;
        // bit = 1
        // 00000...0000000
        long num = 1L << bit;
        switch (value) {
            case 0:
                // 00000...0000000 - 1 = 00000...0000001
                result = (bitMap | num) - num;
                break;
            case 1:
                // 00000...0000000
                result = bitMap | num;
                break;
            default:
                result = bitMap;
        }
        return result;
    }
}
