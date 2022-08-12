package com.levelup.slidingwindow;
/**
Problem statement : Maximum sum subarray of size k in array
e.g
Input :{1,2,5,3,6,8,1,4} and Window size :3
Output :17

 Constraint :
 all element in subarray consist of positive integer
 Total Number of subArray of size 3=  n-2
i.e.
 if n=8 them number of subarray could be 8-2=6
 input :{1,2,5,3,6,8,1,4}
 Then window element could be
 {1,2,5} = 8
 {2,5,3} =10
 {5,3,6} =14
 {3,6,8} =17
 {6,8,1} =15
 {8,1,4} =13
 Brute force  rule
  iterate through all element
      Build window of size 3
         calculate sum of Window of size 3
         initialise sum to max of current sum with new sum
Time complexity :O(n^2)

 */


public class MaxSumOfSubArrayK {
    public static void main(String [] args){
        int [] maxArray={1,2,5,3,6,8,1,14};
        int  windowSize=3;
        System.out.println("BruteForce Method to find Max sum of subarray:"+MaxSubOfSubArrayOfSizeKByBruteForce(maxArray,windowSize));
        System.out.println("OptimizeMethod to find Max sum of subarray:"+MaxSumOfSubArrayOfSizeKOtimize(maxArray,windowSize));

    }

    /**Time complexity O(n^2)**/
    public static int MaxSubOfSubArrayOfSizeKByBruteForce(int [] arr,int k){
        int maxSumOfSubarray=0;
        for(int i=0;i<=arr.length-k;i++){
            int sum=0;
            System.out.println("i:"+i);
            for(int j=i;(j-i)<k;j++){
                System.out.println("j:"+j+"-"+i+" <="+k);
                 sum=sum+arr[j];
                 if((j-i+1)==k){
                     maxSumOfSubarray=Math.max(maxSumOfSubarray,sum);
                     break;
                 }
            }

        }
        return maxSumOfSubarray;
    }

    /**Time complexity O(n)**/
    public static int MaxSumOfSubArrayOfSizeKOtimize(int [] arr,int k){
        int maxSum=0;
        int i=0;
        int j=0;
        int sum=0;
        while(i<=(arr.length)-k){
            sum=sum+arr[j];
            System.out.println(i+":"+j);
          if(j-i+1==k){
              maxSum=Math.max(maxSum,sum);
              sum=sum-arr[i];
              i++;
          }
          j++;
        }
        return maxSum;
    }
}
