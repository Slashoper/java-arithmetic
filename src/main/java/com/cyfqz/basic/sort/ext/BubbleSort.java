package com.cyfqz.basic.sort.ext;

import java.util.Arrays;

/**
 * 冒泡排序 在0-n 范围玩冒泡
 * 学习算法先了解原理 -> code
 * 时间复杂度 O(n2)
 * 空间复杂度 O(1) 只用到几个变量
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/09/05 09:30
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] expect = {273472,231231,10,1,0,2112,8};
        bubbleSort(expect);
        Arrays.stream(expect).forEach(e ->{
            System.out.print(e+ "\t");
        });
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int e = arr.length - 1; e > 0; e--) { // 在 0~e 上 玩冒泡 外层循环控制冒泡的范围
            for(int i =0 ;i <e;i++){
                if(arr[i] > arr[i+1]){
                    swap2(arr,i,i+1);
                }
            }
        }

    }

    /**
     *  0 ^ n = n ,n^n = 0
     * @param arr
     * @param i
     * @param j
     */
    public static void swap2(int[] arr, int i,int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }
}
