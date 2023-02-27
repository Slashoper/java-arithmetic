package com.cyfqz.leecode;

import java.util.HashMap;
import java.util.Map;

public class LeeCode1 {
    public static void main(String[] args) {
        int[] a = {2,3,5,6};
        int t = 11;
        System.out.println(solution(a,t));
    }

    public static int[] solution(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i };
            }
            map.put(nums[i],i);
        }

        return null;
    }
}
