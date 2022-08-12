package com.levelup.calendar;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * Problem Statement
 * https://leetcode.com/problems/my-calendar-ii/
 *Input
 * ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
 * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
 * Output
 * [null, true, true, true, false, true, true]
 * {0=null, 1=true, 2=true, 3=true, 4=false, 5=true, 6=true}
 *
 * Constraint
 * 1.The input time array must be two Dimensional
 * 2.All value in array must be positive
 * 0 <= start < end <= 109
 * At most 1000 calls will be made to book.
 *
 *
 */
public class MyCalendarII {
    TreeMap<Integer,Integer> tm=new TreeMap<>();
    int count=0;
    public boolean bookMeeting(int start,int end) {
        Boolean allowTobook=true;

        tm.put(start,tm.getOrDefault(start,0)+1);
        tm.put(end,tm.getOrDefault(end,0)-1);

        Set<Integer> keys=tm.keySet();
        for(int key:keys){
            count+=tm.get(key);
            if(count>=3){
                count-=1;
                tm.put(start,tm.getOrDefault(key,0)-1);
                tm.put(end,tm.getOrDefault(key,0)+1);
                allowTobook=false;
            }
        }
        //Remove  from map  key value is <=0
        if(tm.get(start)==0){
            tm.remove(start);
        }

        if(tm.get(end)==0){
            tm.remove(end);
        }
        System.out.println(start+","+end+"="+allowTobook);
        return allowTobook;
    }
        public static void main(String [] args){
                MyCalendarII myCalendarII=new MyCalendarII();
                String []calendarName = {"MyCalendarTwo", "book", "book", "book", "book", "book", "book"};
                int [][]calendarTime={{}, {10, 20}, {50, 60}, {10, 40}, {5, 15}, {5, 10}, {25, 55}};
            HashMap<Integer,Boolean> resultMap=new HashMap();
                for(int i=0;i<calendarName.length;i++){
                    int []calTime=calendarTime[i];
                    if(calTime.length>0){
                       boolean flag= myCalendarII.bookMeeting(calTime[0],calTime[1]);
                        resultMap.put(i,flag);
                    }else{
                        resultMap.put(i,null);
                    }

                }
                System.out.println(resultMap);
        }
    }

