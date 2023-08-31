package com.cyfqz.basic.sort.sample;

public class InsertSortDemo {
    public static void main(String[] args) {
        int[] array = {1,323,34232,8,7,3,2,1,10};
        insertSort(array);
        for(int data : array){
            System.out.printf("%d\t",data);
        }
    }

    public static void insertSort(int[] array){
        for(int outer = 1;outer<array.length; outer++){
            int in = outer;
            int tmp = array[outer];
            while(in>0 && array[in-1] >= tmp && in >0){
                array[in] = array[in-1];
                in--;
            }
            array[in] = tmp;
        }

    }
}
