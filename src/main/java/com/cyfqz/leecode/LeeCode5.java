package com.cyfqz.leecode;

public class LeeCode5 {

    public static void main(String[] args) {
        String str ="abefba";
        System.out.println(longestDuplicate(str));
    }

    public static  String longestDuplicate(String str){
        int begin=0;
        int maxLen=1;
        char[] characters = str.toCharArray();
        for(int i=0;i<characters.length-1;i++){
            for(int j=i+1;j<characters.length;j++){
                if(j-i+1> maxLen && validateLongestDuplicate(characters,i,j)){
                    maxLen = j-i+1;
                    begin = i;
//                    System.out.println(i);
                }
            }
        }

        return str.substring(begin,begin+maxLen);

    }

    public static boolean validateLongestDuplicate(char[] chars, int start,int end){
        while(start < end){
            if(chars[start] != chars[end]){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
