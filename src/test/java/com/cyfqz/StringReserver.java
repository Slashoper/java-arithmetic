package com.cyfqz;

public class StringReserver {
    public static void main(String[] args) {
        String a = "abcdefghi";
        char[] letters = a.toCharArray();
        char[] targetLetters = new char[letters.length];
        for (int i=letters.length -1 ;i>=0;i--){
            targetLetters[i] = letters[i];
        }
        String b = new String(targetLetters);
        System.out.println(b);
    }
}
