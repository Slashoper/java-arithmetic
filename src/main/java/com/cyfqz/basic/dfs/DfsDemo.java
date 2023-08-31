package com.cyfqz.basic.dfs;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 深度优先算法
 *
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/08/31 10:20
 */
public class DfsDemo {

    public static void main(String[] args) {
        String str="abc";
        List<String> res = new ArrayList<>();
        boolean[] isVisit = new boolean[str.length()];
        strCombinationDfs(str,isVisit,0,new StringBuffer(),res);
        res.forEach(s -> {
            System.out.println(s);
        });
    }

    /**
     * 字符串排列组合
     * @param str
     * @param isVisit
     * @param index
     * @param sb
     * @param res
     */
    public static void strCombinationDfs(String str, boolean[] isVisit, int index, StringBuffer sb , List<String> res){
        // 1、截止条件
        if ( index == str.length() ) {
            res.add(sb.toString());
            return;
        }

        //2、遍历候选节点
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            //2.1、筛选
            if(!isVisit[i]){
                sb.append(c);
                isVisit[i] = true;
                strCombinationDfs(str,isVisit,index+1,sb,res);
                isVisit[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }

    /**
     *  192168123
     */
    public static void ipCheckCombination(String str,int index,List<String> res){
        if (index == 3){
            return ;
        }


    }

}
