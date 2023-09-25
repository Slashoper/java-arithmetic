package com.cyfqz.basic.dfs;


import java.util.*;

/**
 * 深度优先算法
 *
 * @author slashoper Email:liqan@szlanyou.com
 * @since 2023/08/31 10:20
 */
public class DfsDemo {

    public static void main(String[] args) {
        String str = "abc";
        List<String> res = new ArrayList<>();
        boolean[] isVisit = new boolean[str.length()];
        strCombinationDfs(str, isVisit, 0, new StringBuffer(), res);
        res.forEach(s -> {
            System.out.println(s);
        });

        List<String> res1 = new ArrayList<>();
        ipCheckCombination("19216801", -1, 1, new Stack<>(), res1);
        res1.forEach(s -> {
            System.out.println(s);
        });
    }

    /**
     * 字符串排列组合
     *
     * @param str
     * @param isVisit
     * @param index
     * @param sb
     * @param res
     */
    public static void strCombinationDfs(String str, boolean[] isVisit, int index, StringBuffer sb, List<String> res) {
        // 1、截止条件
        if (index == str.length()) {
            res.add(sb.toString());
            return;
        }

        //2、遍历候选节点
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            //2.1、筛选
            if (!isVisit[i]) {
                sb.append(c);
                isVisit[i] = true;
                strCombinationDfs(str, isVisit, index + 1, sb, res);
                isVisit[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

    /**
     * java substring 截取字符串是从startIndex - endIndex , 不包含endIndex
     * 12916801
     */
    public static void ipCheckCombination(String str, int index, int level, Stack<String> stack, List<String> res) {
        // 中止条件
        if (level == 5 || index == str.length() - 1) {
            if (level == 5 && index == str.length() - 1) {
                res.add(String.join(".", stack));
            }
            return;
        }
        // 候选人
        for (int i = 1; i < 4; i++) {
            String x = str.substring(index + 1, i);
            if (Integer.parseInt(x) < 256 && (x == "0" || !x.startsWith("0"))) {
                stack.push(x);
                ipCheckCombination(str, index + i, level + 1, stack, res);
                stack.pop();
            }
        }

    }

//    public static String sub(String str,int start,int len){
//        return str.substring(start,len + 1);
//    }

}
