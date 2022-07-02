Brute Force
Time Complexity - O(n*n)
Space Complexity - O(1)


class Test {
    static int arr[] = new int[] { 1, 20, 6, 4, 5 };
  
    static int getInvCount(int n)
    {
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (arr[i] > arr[j])
                    inv_count++;
  
        return inv_count;
    }
  
    // Driver method to test the above function
    public static void main(String[] args)
    {
        System.out.println("Number of inversions are "
                           + getInvCount(arr.length));
    }
}















Merge Sort 
Time Complexity - O(nlogn)
Space Complexity - O(n)






// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   // arr[]: Input Array
   // N : Size of the Array arr[]
   //Function to count inversions in the array.
   static long inversionCount(long arr[], long N)
   {
      long temp[] = new long[(int)N];
      return mergeSort(arr,temp,0,N-1);
   }
   static long mergeSort(long arr[],long temp[], long left, long right){
       long count = 0;
       long mid;
       if(left < right){
           mid = (left+right)/2;
           count += mergeSort(arr,temp,left,mid);
           count += mergeSort(arr,temp,mid+1,right);
           
           count += merge(arr,temp,left,mid+1,right);
       }
       return count;
   }
   static long merge(long arr[],long temp[],long left, long mid, long right){
       long i = left;
       long j = mid;
       long k = left;
       long count = 0;
       while(i <= mid-1 && j <= right){
           if(arr[(int)i] <= arr[(int)j]){
               temp[(int)k++] = arr[(int)i++];
           }
           else{
               temp[(int)k++] = arr[(int)j++];
               count += mid-i;
           }
       }
       while(i <= mid-1){
           temp[(int)k++] = arr[(int)i++];
       }
       while(j <= right){
           temp[(int)k++] = arr[(int)j++];
       }
       for(i = left; i <= right; i++){
           arr[(int)i] = temp[(int)i];
       }
       return count;
   }
}
