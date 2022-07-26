package com.levelup.slidingwindow;
/**
        * Problem statement: First Negative Number in every Window of Size K | Sliding Window
        * Input : {1,-3,4,-2,-5,6,15,-8,9}
        * Window Size :3
        * Output : {-3,-3,-2,-2,-5,-8,8)
        * Constraints:
        *  Input array can be any integer
        *  Window size must be positive integer
        * Input : {1,-3,4,-2,-5,6,15,-8,9}
        * Output : first negative element in every subarray
        *  subArray :  First Negative element in sub Array
        *                    i      j       dqeue.add(arr[j]<0    Print
        * {1,-3,4} : {-3}    0      2       {-3}
        * {-3,4,-2} :{-3}    1     3        {-3,-3}
        * {4,-2,-5} :{-2}
        * {-2,-5,6}:{-2}
        * {-5,6,15}:{-5}
        * {6,15,-8}:{-8}
        * {15,-8,9}:{-8}
        * Final Output :{-3,-3,-2,-2,-5,-8,-8}

 *  subArray :  First Negative element in sub Array
 *                              i       j       dqeue.add(arr[j]<0    Print
 * {1,-3,4,-2,-5,6,15,-8,9} :   0       0
 * {1,-3,4,-2,-5,6,15,-8,9}     0       1           {-3}
 * {1,-3,4,-2,-5,6,15,-8,9}     0       2           {-3)}
 * {1,-3,4,-2,-5,6,15,-8,9}     0       1
 * {-5,6,15}:{-5}
 * {6,15,-8}:{-8}
 * {15,-8,9}:{-8}
 * Final Output :{-3,-3,-2,-2,-5,-8,-8}
        */
import java.util.*;
public class FirstNegativeNumberOfEverySubArraySizeK {
    public static void main(String [] args){
        int []arr={1,-3,4,-2,-5,6,15,-8,9};
        int windowSize=3;
        System.out.println("Print first negative window of each sub array");
        showFirstNegativeFromEachWindow(arr,windowSize);

    }
    public static void showFirstNegativeFromEachWindow(int []arr,int k){
        int i=0;
        int j=0;
       Deque<Integer> q=new LinkedList<>();
        while(j<arr.length){
            if(arr[j]<0){
                q.add(arr[j]); //Store all negative integer.
            }
            if(j-i+1<k){ //build first slide window for size k
                j++;
            }else if(j-i+1==k){  //build next Slide window of size k
                if(q.isEmpty()){
                    q.add(0);
                }else if(arr[i]==q.getFirst()){

                }
                i++;
                j++;
              }
        }
    }
}
