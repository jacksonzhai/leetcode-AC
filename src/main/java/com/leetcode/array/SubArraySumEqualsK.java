package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 */
public class SubArraySumEqualsK {
    public static  int subArraySum(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap();
        int length = nums.length;
        int count = 0;
        int sum = 0;
        map.put(0,1);

        for(int i = 0;i<length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(subArraySum(nums,2));
    }
}
