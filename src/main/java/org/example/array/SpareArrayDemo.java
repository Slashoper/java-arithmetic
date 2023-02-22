package org.example.array;

public class SpareArrayDemo {
    public static void main(String[] args) {
        int[][] chessArray = new int[11][20];
        chessArray[0][1] = 1;
        chessArray[1][2] = 2;
        chessArray[10][2] = 2;
        int count=0;
        for(int[] row:chessArray){
            for(int data:row){
                if(data!=0)
                    count++;
                System.out.printf("%d\t",data);
            }
            System.out.println("");
        }

        System.out.println("转化为稀疏矩阵为：");

        int[][] spareArray = new int[count+1][3];
        spareArray[0][0] = 20;
        spareArray[0][1] = 20;
        spareArray[0][2] = count;

        //普通二维数组转化为稀疏矩阵
        int index = 0;
        for(int i= 0;i<11;i++){
            for(int j=0;j<20;j++){
                if(chessArray[i][j]!=0){
                    index++;
                    spareArray[index][0] = i;
                    spareArray[index][1] = j;
                    spareArray[index][2] =chessArray[i][j];
                }
            }
        }
      for(int[] row : spareArray){
          for(int data : row){
              System.out.printf("%d\t",data);
          }
          System.out.println("");
      }

      // 稀疏矩阵转为普通矩阵
        System.out.println(chessArray.length);

    }
}


