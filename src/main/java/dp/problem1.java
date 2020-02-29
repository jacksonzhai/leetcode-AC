package dp;

import java.util.*;

public class problem1 {
    public static  int rec_opt(int[] arr, int index){
        if(index ==0){
            return arr[0];

        }else if(index == 1){
            return Math.max(arr[1],arr[0]);
        }
        else
            return Math.max(rec_opt(arr,index-2)+arr[index],rec_opt(arr,index-1));

    }
    public static int dp_opt(int[] arr,int index){
        int[] re = new int[index];
        for(int i = 0;i<index;i++){
            if(i == 0){
                re[0] = arr[i];
            }else if(i ==1){
                re[1] = Math.max(arr[i],arr[i-1]);
            }
            else{
                re[i] = Math.max(re[i-2]+arr[i],re[i-1]);
            }
        }
        return re[index-1];
    }
    public static boolean subSet(int[] arr,int target){
        return subSetHelper(arr,arr.length-1,target);

    }
    public static boolean subSetHelper(int[] arr,int index,int target){
            if(target ==0) {return  true;}
            else  if(index ==0){return arr[0] == target;}
            else  if(arr[index]>target){return  subSetHelper(arr,index-1,target);}
            else {
                return subSetHelper(arr,index-1,target-arr[index]) || subSetHelper(arr,index-1,target);

            }
    }

    public static boolean dpSubSet(int[] arr,int target){
            boolean[][] sub = new boolean[arr.length][target+1];
            int row = arr.length;
            int col = sub[0].length;
            for(int i = 0;i<col;i++){
                sub[0][i] =false;
            }
            for(int i = 0;i<row;i++){
                sub[i][0] = true;
            }
            if(target>=arr[0]) {
                sub[0][arr[0]] = true;
            }
            for(int r = 1;r<row;r++){
                for(int c = 1;c<col;c++){
                    if(arr[r]>c){
                        sub[r][c] = sub[r-1][c];

                    }else{
                        boolean a = sub[r-1][c-arr[r]];
                        boolean b = sub[r-1][c];
                        sub[r][c] =a||b;
                    }

                }
            }
            return sub[arr.length-1][target];
    }
    public static String dpPalindromic(String s){
        int n = s.length();
        String res = null;
        boolean[][] dp = new boolean[n][n];
        for(int i = n-1;i>=0;i--){
            for(int j = i;j<n;j++){
                dp[i][j] = s.charAt(i) == s.charAt(j)&&(j-i<3||dp[i+1][j-1]);
                if(dp[i][j]&&(res ==null||j-i+1>=res.length())){
                    res = s.substring(i,j+1);
                }
            }
        }
        return res;
    }
    public static String shortestPalindrome(String s){
        int j = 0;
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i) == s.charAt(j)){j+=1;}

        }
        if(j==s.length())return s;
        String  suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString()+ s.substring(0,j)+ suffix;
    }
    public static double  findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] temp = new int[nums1.length+nums2.length];
        int length1 = nums1.length;
        int length2 = nums2.length;
        int flag =  (length1+length2)/2;

        int k = 0;
        int i = 0;
        int j = 0;
        while(k<=flag&&i<length1&&j<length2){
            if(nums1[i]>nums2[j]){
                temp[k++] = nums2[j++];
            }
            else{
                temp[k++] = nums1[i++];
            }

        }
        while(k<=flag&&i<length1){
            temp[k++] = nums1[i++];
        }
        while(k<=flag&&j<length2){
            temp[k++] = nums2[j++];
        }
        if((length1+length2)%2==0){
            return (temp[flag]+temp[flag-1])/2.0;

        }
        return temp[flag]*1.0;



    }
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character,Integer> map = new HashMap();
        int t = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int pre  = map.get(c);
                if(max<t){
                    max = t;
                }
                t = i-pre;

            }
            else{
                t++;
            }
        }
        if(max<t){
            max = t;
        }

        return max;

    }
    public static void main(String[] args) {
        int[] arr = {10,4,7,8,9,10,22,90,10,20,11};
//        int sum = 0;
//        for(int item:arr){
//            sum+=item;
//        }
//        System.out.println(sum);
//        System.out.println(problem1.rec_opt(arr,10));
//        System.out.println(problem1.dp_opt(arr,10));
//        System.out.println(problem1.subSet(arr,sum));
//        System.out.println(problem1.dpSubSet(arr,4));
//        System.out.println(dpPalindromic("babad"));
//        System.out.println(shortestPalindrome("babad"));
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));

    }
}
