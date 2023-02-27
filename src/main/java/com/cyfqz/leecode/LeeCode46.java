package com.cyfqz.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 回溯
 * 1、选择
 * 2、递归
 * 3、
 */
public class LeeCode46 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(solution(nums).size());
        System.out.println(solution2(nums).size());
        System.out.println(solution3(nums).size());
    }

    public static List<List<Integer>> solution3(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs2(res, nums, path, visited);
        return res;
    }

    public static List<List<Integer>> solution(int[] nums) {
        Deque<Integer> path = new ArrayDeque<>();
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int depth = 0;
        boolean[] visited = new boolean[len];

        if (nums == null || nums.length == 0) return res;
        dfs(path, visited, nums, res, depth, len);
        return res;
    }

    public static List<List<Integer>> solution2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (i != j && j != k && i != k) {
                        tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(j);
                        tmp.add(k);
                        res.add(tmp);
                    }
                }
            }
        }
        return res;
    }


    public static void dfs2(List<List<Integer>> res, int[] nums, List<Integer> path, boolean[] visited) {
        if (path.size() == 3) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(nums[i]);
                dfs2(res, nums, path, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }


    public static void dfs(Deque<Integer> path, boolean[] visited, int[] nums, List<List<Integer>> res
            , int depth, int len) {
        if (depth == 3) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.addLast(nums[i]);
                visited[i] = true;
                dfs(path, visited, nums, res, depth + 1, len);
                path.removeLast();
                visited[i] = false;
            }
        }
    }
}
