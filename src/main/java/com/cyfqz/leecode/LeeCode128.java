package com.cyfqz.leecode;

/**
 * 最长连续递增序列
 */
public class LeeCode128 {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int ans = 0;
        int[] m = new int[nums.length];
//        for (int n : m) {
//            n = -1;
//        }
        for(int i =0;i< m.length;i++){
            m[i] = -1;
        }
//        return process2(nums,0,m);
        for (int i = 0; i < nums.length; i++) {
//            ans= Math.max(process1(nums,i),ans);
            ans = Math.max(process2(nums, i, m),ans);
        }
        return ans;
    }

    public static int process1(int[] nums, int index) {
        int ans = 1;
        if (index == nums.length - 1) {
            return ans;
        }
//        int[] m = new int[nums.length];
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > nums[index])
                ans = Math.max(process1(nums, i) + 1, ans);
        }

        return ans;
    }


    public static int process2(int[] nums, int index, int[] m) {
        int ans = 1;
        if (m[index] != -1) {
            return m[index];
        }
        if (index == nums.length - 1) {
            return ans;
        }
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > nums[index])
                ans = Math.max(process2(nums, i, m) + 1, ans);
        }
        m[index] = ans;
        return ans;
    }
}
