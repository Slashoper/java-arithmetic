package com.cyfqz.basic.bitoperation;

/**
 * 位运算例题
 *
 * 一个数组中，有一个奇数，其他都是偶数，打印这个偶数
 * 一个数组中，有两个奇数，其他都是偶数，打印这两个奇数
 *
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/09/05 13:53
 */
public class EventTimesOddTimes {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,3,2,2,2,2};
        printOddTimesNum1(arr);

        int[] arr2 ={1,1,1,1,3,2,2,2,2,5};
        printOddTimesNum2(arr2);
//        printOddTimesNum2(arr);
    }

    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for ( int cur : arr){
            eor ^= cur;
        }
        System.out.println(eor);
    }


    public static void printOddTimesNum2(int[] arr){
        int eor = 0, onlyOne = 0;
        for (int curNum : arr){
            eor ^= curNum;
        }
        // eor = a^b
        // eor != 0
        // eor必然有一个位置是1
        int rightOne = eor & (~eor +1); // 提取最右的1
        for (int cur : arr){
            if((cur & rightOne) == 0){
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

}
