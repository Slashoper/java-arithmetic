package com.cyfqz.basic.sort.ext;

import java.util.Arrays;

/**
 * 选择排序 很容易理解
 * 时间复杂度 O(n2)
 * 空间复杂度 O(1)
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/09/05 09:16
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr ={9,5,7,2,3,2};
        selectionSort(arr);
        Arrays.stream(arr).forEach(e -> {
            System.out.print(e + "\t");
        } );
    }

    public static void selectionSort(int[] arr){
        if( arr == null || arr.length<2){
            return ;
        }

        for ( int i=0;i <arr.length -1 ;i++){
            int minIndex = i;
            for ( int j = i+1; j<arr.length;j++){// i~ N-1.
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }

    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j]  = tmp;
    }
}
