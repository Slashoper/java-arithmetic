package com.cyfqz.leecode;

/**
 * ( ( ) ( ) )
 * 取最长括号长度
 */
public class LongestBrackets {

    public static void main(String[] args) {
        String s = "())";
        System.out.println(longestBrackets(s));

    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static int longestBrackets(String s){
        if ( s == null  || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len];
        int res = 0;
        for ( int i=1 ;i < len;i++){
            if (s.charAt(i) == ')' && s.charAt(i-1) == '('){
               dp[i] =  (i > 1) ? 2 + dp[i-2] : 2;
            }else if (s.charAt(i) == ')' && s.charAt(i-1) == ')'){
                if((i - dp[i-1]-1 >=0 ) && s.charAt(i - dp[i-1]-1) == '('){
                    dp[i] = i-dp[i-1]-2 > 0 ?  2+ dp[i-dp[i-1]-2] + dp[i-1] : 2 + dp[i-1];
                }
            }
            res = Math.max(res,dp[i]);
        }


        return res;
    }
}
