package com.levelup.slidingwindow;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Given two strings s and p,
 * return total number of Anagram  in String S of p
 * return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * Input:
 * s = "cbaebabacd",
 * p = "abc"
 * Output: 2
 *  {cba,bac}
 * Output:
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class CountNumberOfAnagramOfSubArrayOfSizeK {
    public static void main(String []args){
        String text="cbaebabacd"; //Original string from which we should count no of possible anagram
        String word="abc";  // find Anagrom of word
        countAnagramsOfStringSizek(text,word);
    }
    public static void countAnagramsOfStringSizek(String t,String w){

        int tLenght=t.length();
        int wLength=w.length();
        int count=0;
         for(int i=0;i<tLenght-wLength;i++){
             String subArrayStr=t.substring(i,i+wLength); // build String of size w.
              if(isAnagrama(subArrayStr,w)){
                  count++;
              }
        }
         System.out.println("Total No of Anagram in text "+t+ " is "+count);
    }

     public static Boolean isAnagrama(String wStr,String pStr){
         char [] wArr=wStr.toCharArray();
         char [] pArr=pStr.toCharArray();
         Arrays.sort(wArr);
         Arrays.sort(pArr);
         if(Arrays.equals(wArr,pArr)){
             return true;
         }else{
             return false;
         }
     }
    public static void countAllPossibleAnagram(String s,String w){
        int j=0;
        int i=0;
        StringBuilder sb=new StringBuilder();
        while(j<s.length()){
             sb.append(s.charAt(j));
             if(j-i+1<w.length()){
                 j++;
             }
             if(j-i+1==w.length()){
             //TODO:
                 // sb.
            }
        }

    }
}
