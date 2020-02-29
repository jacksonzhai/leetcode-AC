package com.leetcode.array.sort;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] nums,int begin,int end){
        if(end>begin) {
            int mid = begin + (end - begin) / 2;
            sort(nums,begin,mid);
            sort(nums,mid+1,end);
            merge(nums,begin,mid,end);
        }



    }
    public static void  merge(int[] nums,int l,int mid,int r ) {
        int[] temp = new int[r-l+1];
        int i = l , j = mid+1;
        int k =0;
        while(i<=mid&&j<=r){
            if(nums[i]<nums[j]){
                temp[k++] = nums[i++];
            }
            else{
                temp[k++] = nums[j++];
            }

        }
        while(i<=mid){
            temp[k++] = nums[i++];
        }
        while(j<=r){
            temp[k++] = nums[j++];
        }
        for(int m = 0;m<r-l+1;m++){
            nums[l+m] = temp[m];

        }

    }
    public static void noRecursionSort(int[] nums ,int l,int r){
        int step = 1;
        int length = r-l+1;

        while(step<=length){
            for(int k = l;k<length;k+=step) {
                int tl = k;
                int tr = k+step-1;
                if(tr>r)tr = r;
                int[] temp = new int[step];
                int mid =  tl+(tr-tl)/2;
                int ll = tl;
                int rl = mid+1;
                int tk = 0;
                while(ll<=mid&&rl<=tr){
                    if(nums[ll]<nums[rl]){
                        temp[tk++] = nums[ll++];
                    }
                    else{
                        temp[tk++] = nums[rl++];
                    }

                }
                while(ll<=mid){
                    temp[tk++] = nums[ll++];
                }
                while(rl<=tr){
                    temp[tk++] = nums[rl++];
                }
                int m= 0;
                while(m<step&&(tl+m)<=tr) {
                    nums[tl + m] = temp[m];
                    m++;
                }

                }
            step+=1;
            }
        }



    public static void main(String[] args) {
        int[] nums = {1,0,8,9,7,4,3,6,-1,-2,-3};
        //sort(nums,0,nums.length-1);
        noRecursionSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }


}
