package com.cyfqz.basic.kmp;

/**
 * KMP算法
 *
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/09/01 10:05
 */
public class KmpDemo {

    public static void main(String[] args) {
        String s = "abcabcabcdfsadfafa";
        String p = "adfafa";
        System.out.println(getIndexOf(s,p));
    }

    /**
     * 返回匹配字符串对应的索引kmp
     * @param s
     * @param m
     * @return
     */
    public static int getIndexOf(String s, String m ){
        if ( s == null || m == null || m.length() < 1 || s.length() < m.length() )
            return -1;

        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 =0;
        int i2 = 0;
        int[] next = getNextArray(str2);

        while(i1 < str1.length && i2 < str2.length){
            if(str1[i1] == str2[i2]){
                i1++;
                i2++;
            }else if (next[i2] == -1){
                i1++;
            }else{
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] ms){
        if(ms.length == 1){
            return new int[] {-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int i=2; // next 数组的位置
        int cn = 0;
        while( i < next.length){
            if (ms[i-1] == ms[cn]){
                next[i++] = ++ cn;
            } else if(cn >0 ){ // 当前跳到cn位置的字符和i-1字符匹配不上
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }

        return next;

    }


}
