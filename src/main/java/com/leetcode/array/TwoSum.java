package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap();
        int[] re = new int[2];
        for(int i = 0; i< nums.length;i++){
            if(map.containsKey(target-nums[i])){
                re[0] = map.get(target-nums[i]);
                re[1] = i;

            }
            map.put(nums[i],i);

        }
           return re;

    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums,9)));
    }
}
