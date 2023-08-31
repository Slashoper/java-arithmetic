package com.cyfqz.basic.sort.sample;

/**
 *
 * 一直以为自己理解了选择排序，其实不然。出了好多问题 ~ ~
 */
public class SelectSortDemo {
    public static void main(String[] args) {
        int[] a = {2,5,2,3,6,7,9,10,8,5,3,2,1};
        selectSort(a);
        for(int data : a){
            System.out.printf("%d\t",data);
        }
    }

    public static void selectSort(int[] a){
        for(int outer=0;outer<a.length-1;outer++){
            int min = outer;
            for(int in=outer+1;in<a.length;in++){
                if(a[in]<a[min]){
                    min = in; // 有可能有多个元素都比min小，所以要记录下来
                }
            }
            int tmp = a[min];
            a[min] = a[outer];
            a[outer] = tmp;
        }
    }
}
