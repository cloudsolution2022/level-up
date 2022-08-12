package com.levelup.slidingwindow;

import java.util.HashMap;

/**
 * Leetcode 560  subarray sum equal to k
 * Problem Statement:
 *              Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *              A subarray is a contiguous non-empty sequence of elements within an array.
 *  input :{1,2,-1,,-1,4,-1,4,2}
 *  target=3
 *  Constraint
 *  1<inputArr.length<=2*10^4
 *  -1000<inputArr[i]<=10^4
 *  -10^7<target<=10^7
 *
 *  Pseudo code
 *  Input:              1   2   -2  -1  3   -1  4   2
 *  Target:3
 *  sum+=Arr[i]     0   1   3   1   0   3   2   6   8
 *  FreqMapSumKey:  0   1   3   1   0   3   2   6   8
 *  FreqMapSumVal:  1   1   1   2   2   2   1   1   1
 *  AnswerCount     0   0   1   0   0   1   0   1   0
 *  Ans = 3
 *   Output :3
 *  *  {{0,1}{1,2,-3}}
 *  Input: arrInt3={3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1};
 *  Target :5
 *  Output :7
 *  {{}}
 *   for each element in  arr
 *      sum=sum+arr[i]
 *      remaimingSum=sum-target
 *      if(freqMap.containsKey(remaimingSum))
 *          ans+=freqMap.get(remainingSum)
 *      freqMap.put(sum,freqMap.getdefaultValue(sum,0)+1)
 **/
public class FindSubArrayEqualToK{

    public static int countSubArrayOfSizeK(int [] inputArr,int target){
        int i=0;
        int sum=0;
        int rSum=0;
        int ans=0;
        HashMap<Integer,Integer>  freqMap=new HashMap<Integer,Integer>();
        freqMap.put(0,1);

        while(i<inputArr.length){
            sum+=inputArr[i];
            rSum=sum-target;
            if(freqMap.containsKey(rSum)){
                int freqKeyVal=freqMap.get(rSum);
                ans+=freqKeyVal;
            }
            freqMap.put(sum,freqMap.getOrDefault(sum,0)+1);
            i++;
        }
        return ans;
    }
    public static void main(String args[]){
        int []arrInt={1,2,4,-2,3,0};
        int targetSum=3;
        int ans=countSubArrayOfSizeK(arrInt,targetSum);
        System.out.println("Number of subArray of size k="+targetSum+" "+ans);

        int []arrInt2={1,2,3};
        int targetSum2=3;
        int ans2=countSubArrayOfSizeK(arrInt2,targetSum2);
        System.out.println("Number of subArray of size k="+targetSum2+" "+ans2);

        int []arrInt3={3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1};
        int targetSum3=5;
        int ans3=countSubArrayOfSizeK(arrInt3,targetSum3);
        System.out.println("Number of subArray of size k="+targetSum3+" "+ans3);

        int []arrInt4={1,1,1};
        int targetSum4=2;
        int ans4=countSubArrayOfSizeK(arrInt4,targetSum4);
        System.out.println("Number of subArray of size k="+targetSum4+" "+ans4);
    }

}
