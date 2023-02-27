package com.cyfqz.leecode;

import java.util.HashSet;
import java.util.Set;

public class StringDuplicate {
    public static void main(String[] args) {

    }

    public static void strDup(String str){
        int len = str.length();
        Set<Character> set;
        for(int i=0;i<len;i++){
            set = new HashSet<>();
            if(!set.contains(str.charAt(i))){
                set.add(str.charAt(i));
            }

        }
    }
}
