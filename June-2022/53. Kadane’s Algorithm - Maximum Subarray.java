//1st solution(bruteforce)

/*Approach: Using brute force

Approach: Using three for loops, we will get all possible subarrays in two loops and their sum in another loop, and then return the maximum of them.*/

// Time Complexity: O(N^3)- TLE 

// Space Complexity: O(1)

import java.util.*;
class CodeXam {
    public static int maxSubArray(int[] nums, ArrayList < Integer > subarray) {
        int max_sum = 0;
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        for (int i = 0; i <= n - 1; i++) {
            for (int j = i; j <= n - 1; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++)
                    sum = sum + nums[k];
                if (sum > max_sum) {
                    subarray.clear();
                    max_sum = sum;
                    subarray.add(i);
                    subarray.add(j);
                }
            }
        }
        return max_sum;
    }
    public static void main(String args[]) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        ArrayList < Integer > subarray = new ArrayList < > ();
        int lon = maxSubArray(arr, subarray);
        System.out.println("The longest subarray with maximum sum is " + lon);
        System.out.println("The subarray is ");
        for (int i = subarray.get(0); i <= subarray.get(1); i++) {
            System.out.print(arr[i] + " ");
        }

    }
}

 

//___________________________________________________________________________________


//2nd solution (Better approach) 
/* Intuition: We can also do this problem using only two for loop, starting the function with ( max_sum ) variable which will have the final answer.
 We can get the sum of all possible subarrays in this way and then return the maximum so far.*/

// Time Complexity: O(N^2) 

// Space Complexity: O(1)

import java.util.*;
class CodeXam {
    public static int maxSubArray(int[] nums, ArrayList < Integer > subarray) {
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curr_sum = 0;
            for (int j = i; j < nums.length; j++) {
                curr_sum += nums[j];
                if (curr_sum > max_sum) {
                    subarray.clear();
                    max_sum = curr_sum;
                    subarray.add(i);
                    subarray.add(j);
                }
            }
        }
        return max_sum;
    }
    public static void main(String args[]) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        ArrayList < Integer > subarray = new ArrayList < > ();
        int lon = maxSubArray(arr, subarray);
        System.out.println("The longest subarray with maximum sum is " + lon);
        System.out.println("The subarray is ");
        for (int i = subarray.get(0); i <= subarray.get(1); i++) {
            System.out.print(arr[i] + " ");
        }

    }
}




//___________________________________________________________________________________


//3rd solution (optimal approach) 

/*Intuition: Basically this problem can be done in linear time complexity with Kadane’s algorithm along with that will also get the subarray which is giving the largest positive-sum. 

Approach: 

-> We will have the following variables in the beginning : 

msf – max so far, meh – max end here, start – to get the starting index of ans’s subarray, end – to get the ending index of ans’s subarray. 

-> Traverse the array starting with adding the ith element with max_end_here(meh) , now we will check that adding the element gives greater value than max_so_far(msf) , if yes then we will update our msf and also update the starting and ending index . 

for(int i=0;i<nums.size();i++){ 
    meh+=nums[i]; 

    if(meh>msf){ msf=meh; start=s; end=i; } 

    if(meh<0){meh=0; s=i+1;} 
} 
->Now in this step, we will print the answer subarray using the start and end variables.

->Return the largest subarray sum that is:- msf. */


// Time Complexity: O(N) 

// Space Complexity:O(1)

import java.util.*;
class CodeXam{
public static int maxSubArray(int[] nums,ArrayList<Integer> subarray) { 
int msf=nums[0] , meh=0 ; 
int s=0;
for(int i=0;i<nums.length;i++){ 
meh+=nums[i]; 
if(meh>msf)
{ 
    subarray.clear();
    msf=meh; 
    subarray.add(s); 
    subarray.add(i); 
    
} 
if(meh<0)
{
    meh=0; 
    s=i+1;
    
} 
} 
 
return msf; 
} 
    public static void main(String args[])
    {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        ArrayList<Integer> subarray=new ArrayList<>();
        int lon=maxSubArray(arr,subarray);
        System.out.println("The longest subarray with maximum sum is "+lon);
        System.out.println("The subarray is ");
        for(int i=subarray.get(0);i<=subarray.get(1);i++)
        {
            System.out.print(arr[i]+" ");
        }
        
    }
}




//*************************************************************

//LEETCODE

//************************************************************


// My Code

class Solution{
   public int maxSubArray(int[]nums){
        int sum=0;
        int maxi=nums[0];
        for(int i=0; i< nums.length; i++){
            sum += nums[i];
            if(sum>maxi)maxi=sum;
            if(sum < 0) sum = 0;
       }
        return maxi;
   }
}
 


//same
//optimal
//Time Complexity - O(n)
//Space Complexity - O(1)
class Solution{

      // Kadane’s Algorithm
    public int maxSubArray(int[]nums){

        //Kadane’s Algorithm - O(n)
        int sum = 0;//sum of the current subarray
        int maximum = nums[0];//maximum sum of the subarray

        for(int i=0; i< nums.length; i++){//iterate through the array

            sum += nums[i];//add the current element to the sum

            if(sum > maximum){//if the sum is greater than the maximum, update the maximum
                maximum=sum;//update the maximum
            }


            if(sum < 0){//if the sum is less than 0, reset the sum to 0
                sum = 0;//reset the sum
            }

        }

        return maximum;
    }
}








//*************************************************************

//Coding Ninja - https://www.codingninjas.com/codestudio/problems/630526?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

//************************************************************


import java.util.* ;
import java.io.*; 

public class Solution {
    
    public static long maxSubarraySum(int[] arr, int n) {
        long max = 0;
        long sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            max = Math.max(sum, max);
            if(sum<0){
                sum =0;
            }
            
        }
        return max;
    }

}









