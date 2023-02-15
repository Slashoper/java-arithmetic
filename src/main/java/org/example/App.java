package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        int[] arrays = {7,1,32,9,8,2,10};
        bubbleSort(arrays);
        for ( int element : arrays){
            System.out.println(element);
        }
    }

    public static void bubbleSort(int[] targetArray){
        int length = targetArray.length;
        for (int i=length-1; i > 0; i--){
            for (int j = 0;j < i; j++ ){
                if ( targetArray[j] > targetArray[j+1]){
                    int tmp = targetArray[j];
                    targetArray[j] = targetArray[j+1];
                    targetArray[j+1] = tmp;
//                    swap(targetArray[j], targetArray[j+1]);
                }
            }
        }
    }

    public static void swap(int a, int b){
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
    }

}
