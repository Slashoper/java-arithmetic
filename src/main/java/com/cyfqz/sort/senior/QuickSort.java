package com.cyfqz.sort.senior;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int length = 10;
        int[] a = new int[length];
        Random random = new Random();
        for(int i=0;i<length;i++){
            a[i] = random.nextInt(length);
        }
        System.out.println("数组排序前为：");
        for(int e:a){
            System.out.printf("%d\t",e);
        }
        quickSort(a,0,length-1);
        System.out.println("\n数组经过快速排序后为：");
        for(int e:a){
            System.out.printf("%d\t",e);
        }

    }

    public static void quickSort(int[] a,int l,int r){
        if(l>r)
            return;
        int base = a[l];
        int i = l;
        int j = r;
        while(i != j){
            while (a[j]>=base && i<j){
                j--;
            }
            while (a[i]<=base && i<j){
                i++;
            }
            if(i<j) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }

        a[l] = a[i];
        a[i] = base;

        quickSort(a,l,i-1);
        quickSort(a,i+1,r);
    }


//    public static void sort(int[] array,int left,int right) {
//
//        if(left > right) {
//
//            return;
//
//        }
//
//// base中存放基准数
//
//        int base = array[left];
//
//        int i = left, j = right;
//
//        while(i != j) {
//
//// 顺序很重要，先从右边开始往左找，直到找到比base值小的数
//
//            while(array[j] >= base && i < j) {
//
//                j--;
//
//            }
//
//// 再从左往右边找，直到找到比base值大的数
//
//            while(array[i] <= base && i < j) {
//
//                i++;
//
//            }
//
//// 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
//
//            if(i < j) {
//
//                int tmp = array[i];
//
//                array[i] = array[j];
//
//                array[j] = tmp;
//
//            }
//
//        }
//
//// 将基准数放到中间的位置（基准数归位）
//
//        array[left] = array[i];
//
//        array[i] = base;
//
//// 递归，继续向基准的左右两边执行和上面同样的操作
//
//        // i的索引处为上面已确定好的基准值的位置，无需再处理
//
//        sort(array, left, i -1);
//
//        sort(array, i +1, right);
//
//    }



}
