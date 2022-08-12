package com.levelup.slidingwindow;
import java.util.HashMap;

/**
 * Problem:Given an arr[] containing n integers and a positive integer k.
 * The problem is to find the longest subarray’s length with the sum
 * of the elements divisible by the given value k.
 * Input: arr[] = {2, 7, 6, 1, 4, 5}, k = 3
 * Output: 4
 * Explaination: The subarray is {7, 6, 1, 4} with sum 18, which is divisible by 3.
 * Input: arr[] = {-2, 2, -5, 12, -11, -1, 7}, k = 3
 * Output: 5
 *
 * Pseudo Code:
 * nums             :      -2   2   -5  12  -11 -1  7
 * Index            :  -1   0   1   2   3   4   5   6
 * Divisible num K  :3
 * sum              :   0   -2  0   -5  7   4   2   9
 * remainder           -1   1   0    2  1
 * remFreq
 *      Key              0  1       2
 *      Value           -1  0   1   2   3   4   5   6
 * Ans
 *
 *
 *
 */

public class LongestSubArrayWithSumDivisibleByK {
    public  static int solution(int []nums,int k){
        int ans=0;
        int sum=0;
        HashMap<Integer,Integer>  remIndexFreq=new HashMap<Integer,Integer>();
        remIndexFreq.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int remainder=sum%k;
            if(remainder<0){
                remainder+=k;
            }
            if(remIndexFreq.containsKey(remainder)){
                ans=Math.max(ans,i-remIndexFreq.get(remainder));
            }else{
                remIndexFreq.put(remainder,i);
            }
        }

        return ans;
    }

    public static void main(String []args){
        int [] nums={1,3,5,-1,4,-3,6,7,-4};
        int k=5;
        int ans=solution(nums,k);
        System.out.println("The Length of longest subarray sum divisible by k="+k+" is "+ans);



        int [] nums1={2, 7, 6, 1, 4, 5};
        int k1=3;
        int ans1=solution(nums1,k1);
        System.out.println("The Length of longest subarray sum divisible by k="+k1+" is "+ans1);

    }
}
