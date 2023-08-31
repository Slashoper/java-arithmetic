package com.cyfqz.basic.sort;

/**
 * 归并排序 n*logn
 *
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/08/29 09:32
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2,10,8,2,1,2,34,342,2,34,6};
        process(arr,0,arr.length-1);

        for(int e : arr){
            System.out.printf("%d\t",e);
        }
    }

    /**
     * 给定数组arr, 范围L...R有序
     * @param arr
     * @param L
     * @param R
     */
    public static void process(int[] arr,int L,int R){
        if ( L == R ){
            return ;
        }
        int mid = L + ((R -L) >> 1);
        process(arr,L, mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    /**
     * 合并
     * @param arr
     * @param L
     * @param M
     * @param R
     */
    public static void merge(int[] arr,int L,int M,int R){
        int p1 = L;
        int p2 = M + 1;
        int[] help = new int[R - L +1];
        int i = 0;
        while(p1 <= M && p2 <= R){
           help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1<=M){
            help[i++] = arr[p1++];
        }

        while (p2<=R){
            help[i++] =arr[p2++];
        }

        for(int j= 0; j< help.length;j++){
            arr[L+j] = help[j];
        }
    }
}
