// Time Coplexity - o(nlog n)+O(n)
// Space - O(n)



import java.util.* ;
import java.io.*;

class Solution {

    public int[][] merge(int[][] intervals) { // [1,3],[2,6],[8,10],[15,18]
        if (intervals.length == 0) { // if there are no intervals
            return new int[0][0]; // return an empty array
        }
      
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0])); //sort the intervals by start time
 

        Stack<int[]> stack = new Stack(); //create a stack to store the intervals' and int[] is an array of two integers {start, end}
        stack.add(intervals[0]);//add the first interval to the stack

        for(int i=1; i<intervals.length; i++) {
            int[] top = stack.peek(); 
            //get the top element of the stack (the last interval) 
            //and store it in top variable (start, end) (top[0], top[1])
          
          
            //if the current interval's start time is less than or equal to the top 
            //interval's end time then merge the two intervals and pop the top interval from the stack


            if(top[1] >= intervals[i][0]) { //if the end time of the top element is greater than or equal to the start time of the current element
                top[1] = Math.max(top[1], intervals[i][1]); //update the end time of the top element
            } else {
                stack.add(intervals[i]); //else add the current element to the stack
            }
        }
      
      
      
        int[][] output = new int[stack.size()][2]; //create an array of size equal to the size of the stack
 //iterate through the stack and store the elements in the output array in reverse order (the last element will be the first element in the output array)
        for(int i=output.length-1;i>=0;i--){ 
            int[] poparray = stack.pop(); //pop the top element from the stack and store it in pop array (start, end)
            output[i][0] = poparray[0]; //store the start time of the popped element in the output array
            output[i][1] = poparray[1]; //store the end time of the popped element in the output array
        }
        return output; //return the output array
    }

}










// Another Type 

class Solution {

         public int[][] merge(int[][] intervals) {    
    
           Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0])); //O(nlogn)
           Stack<int[]> stack = new Stack(); //O(n)
           stack.add(intervals[0]);
        
        
        for(int i=1;i<intervals.length;i++){
            
            int startpoint2 = intervals[i][0];
            int endpoint2 = intervals[i][1];
            
            int[] poparray = stack.pop();
            
            int startpoint1 = poparray[0];
            int endpoint1 = poparray[1];
            
            int endmax = Math.max(endpoint2,endpoint1);
                
            if(endpoint1>=startpoint2){
                int[] merge = new int[]{startpoint1,endmax};
                stack.add(merge);
            }else{
                stack.add(poparray);
                stack.add(intervals[i]);
            }
             
        }
        
        int[][] output = new int[stack.size()][2];
        
        for(int i=output.length-1;i>=0;i--){
            int[] poparray = stack.pop();
            output[i][0] = poparray[0];
            output[i][1] = poparray[1];
        }
        return output;
    }

}


















// Coding Ninja
// https://www.codingninjas.com/codestudio/problems/699917?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        List<Interval> mergedInvervals = new ArrayList<>();
        
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2)
            {
                return i1.start-i2.start;
            }
        });
        
        int newStart = intervals[0].start;
        int maxFinish = intervals[0].finish;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start <= maxFinish){
                maxFinish = Math.max(maxFinish, intervals[i].finish);    
            }else{
                mergedInvervals.add(new Interval(newStart, maxFinish));
                newStart =  intervals[i].start;
                maxFinish = intervals[i].finish;
            }
        }
        
        mergedInvervals.add(new Interval(newStart, maxFinish));
        return mergedInvervals;
    }
}