package com.leetcode.array.sort;

import java.util.Arrays;

public class QuickSort {
    public  static  void  sort(int[] nums,int begin,int end){
        if(begin<end){
            int pos = getPosition(nums,begin,end);
            sort(nums,begin,pos-1);
            sort(nums,pos+1,end);
        }
    }
    public static int getPosition(int[] nums,int begin,int end){
        int pos = begin;
        int flag = nums[begin];
        int i = begin+1;
        int j = end;
        while(i<j) {
            while (flag < nums[j] && i <= j) j--;
            while (flag >nums[i] && i < j) i++;
            if (i < j) {
                swapArrayItem(nums, i, j);
                i++;
                j--;
            }
        }

            nums[pos] = nums[j];
            nums[j] = flag;
            pos = j;

        return pos;
    }
    public static  void swapArrayItem(int[] nums,int i,int j){
        int temp  = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,9,4,5,7,6};
        sort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));

    }
}
