package org.example.sort.senior;

import java.util.Random;

public class ShellSort {
    public static void main(String[] args) {
        int len = 10;
        Random random = new Random();
        int[] a = new int[len];
        for(int i=0;i<len;i++){
            a[i] = random.nextInt(len);
        }
        System.out.println("排序前的数组为:");
        for(int e : a){
            System.out.printf("%d\t",e);
        }
        System.out.println("\n排序后的数组为:");
        shellSort(a);
        for(int e : a){
            System.out.printf("%d\t",e);
        }
    }

    public static void shellSort(int[] a){
        for(int gap = a.length/2 ; gap >0 ; gap/=2) {
            for (int i = gap; i < a.length; i++) {
                int j;
                int tmp = a[i];
                for (j = i; j >=gap && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }
}
