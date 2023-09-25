package com.cyfqz.basic.sort.ext;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序  0 ~ n 上一个一个的数比较往前面插入
 * 时间复杂度以最坏的角度来考虑 O(n2)
 * 空间复杂度O(1) , 只用到几个特殊的变量
 *
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/09/05 18:08
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        insertSort(arr);
        int[] expectArr = generateRandomArray(10000, 500000);
        long start = System.currentTimeMillis();
        insertSort(expectArr);
        long end = System.currentTimeMillis();
        System.out.printf("耗时:%d秒\n", (end - start) / 1000);
        Arrays.stream(expectArr).forEach(e -> {
            System.out.print(e + "\t");
        });
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) { // 0 ~ n  0 ~ i 有序
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generateRandomArray(int maxValue, int maxSize) {
        int[] expectArray = new int[maxSize];
        Random random = new Random();
        for (int i = 0; i < maxSize; i++) {
//            expectArray[i] = (int) Math.random() * maxSize;
            expectArray[i] = random.nextInt(maxValue);
        }

        return expectArray;
    }
}
