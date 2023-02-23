package com.cyfqz.sort.sample;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {3,2,1,2,23,32,33,2,1,324,3,32,23,23,60,61};
        System.out.println("排序前的数组为：");
        for(int i:array){
            System.out.printf("%d\t",i);
        }
        solution(array);
        System.out.println("\n排序后的数组为：");
        for(int i:array){
            System.out.printf("%d\t",i);
        }
    }

    public static void solution(int[] array){
        for(int outer=array.length-1;outer>0;outer--){
            for(int i=0;i<outer;i++){
                if(array[i]>array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }
}
