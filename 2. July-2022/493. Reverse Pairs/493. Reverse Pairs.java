
Brute - TimeComplxity - Time Complexity: O (N^2) ( Nested Loops )

Space Complexity:  O(1)




class Solution {
    public int reversePairs(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = i+1; j < arr.length; j++)
                if ((long)arr[i] > (long)2 * arr[j])   
                    count++;
        return count;
    }
}









Optimal - Time Complexity : O( N log N ) + O (N) + O (N)   

Reason : O(N) – Merge operation , O(N) – counting operation ( at each iteration of i , j doesn’t start from 0 . Both of them move linearly ) 

Space Complexity : O(N) 

Reason : O(N) – Temporary vector



class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length; // n is the length of the array
        return mergeSort(nums,0,n-1); // calling the merge sort function to sort the array
    }

    private int mergeSort(int[]nums,int strtIdx, int endIdx){

        if (strtIdx>=endIdx){//if zero elements in the array or one element in the array
            return 0;
        }
        int count = 0; //count is the number of pairs of elements in the array
        int mid = strtIdx + (endIdx - strtIdx)/2; //mid is the mid-point of the array


        //start index to mid index means left subarray and mid+1 to end index means right subarray

        count +=mergeSort(nums,strtIdx,mid); //count pairs and recursively call the merge sort function to sort the left subarray
        count +=mergeSort(nums,mid+1,endIdx);//count pairs and recursively call the merge sort function to sort the right subarray
        count +=merge(nums,strtIdx,mid,endIdx);//count pairs and recursively call the merge function to sort the left subarray and right subarray
        return count;//return the number of pairs of elements in the array
    }

    private int merge(int[]nums,int strtIdx,int mid, int endIdx){ //we need mid for the left subarray and endIdx for the right subarray
        int count = 0;//count is the number of pairs of elements in the array

        //size of the array is endIdx-strtIdx+1 means the size of the left subarray and right subarray
        int[]a = new int[endIdx-strtIdx+1];//a is the array to store the elements of the left subarray and right subarray respectively
        int index = 0;//index is the index of the array


        //i is the start index of the left subarray and j is the start index of the right subarray
        int i = strtIdx,j = mid+1;
        

       //while the start index of the left subarray is less than or equal to the end index of the left subarray
       // and the start index of the right subarray is less than or equal to the end index of the right subarray
        while(i<=mid && j<= endIdx){


            //if the element of the left subarray is greater than 2 times the element of the right subarray then increment the count
            // by 1 and increment the j index by 1 to move to the next element of the right subarray
            if((long) nums[i] > 2*(long) nums[j]){//if the element of the left subarray is greater than 2 times the element of the right subarray
                count+= mid - i+1; //we do this because we need to count the number of pairs of elements in the left subarray also considering the mid index
                j++;//increment the j index by 1 to move to the next element of the right subarray
            }
            else
            {
                i++;//increment the i index by 1 to move to the next element of the left subarray
            }
        }
         //while the start index of the left subarray is less than or equal to the end index of the left subarray
        i = strtIdx;
        j = mid +1 ;
        while (i<= mid && j <= endIdx) {
            if(nums[i]>nums[j]){
                a[index++] = nums[j++];
            }
            else {
                a[index++] = nums[i++];
            }


        }
        while (i <= mid ){
            a[index++]=nums[i++];
        }
        while (j <= endIdx){
            a[index++] = nums[j++];
        }
        System.arraycopy(a,0,nums,strtIdx,endIdx-strtIdx+1);
        return count ;
    }


}



_____________________________________________________________________________________________________

Solution 1: Brute Force Approach

Intuition : 

As we can see from the given question that i < j, So we can just use 2 nested loops and check for the given condition which is arr [i] > 2* arr[j].

Approach:

We will be having 2 nested For loops the outer loop having i as pointer 
The inner loop with j as pointer and we will make sure that 0 <= i < j < arr.length() and also arr[i] > 2*arr[j] condition must be satisfied.






Solution 2: Optimal Solution

Intuition:

-> We will be using the Merge Sort Algorithm to solve this problem. We split the whole array into 2  parts creating a Merge Sort Tree-like structure. During the conquer step we do the following task : 

-> We take the left half of the Array and Right half of the Array, both are sorted in themselves. 

-> We will be checking the following condition arr[i] <= 2*arr[j]  where i is the pointer in the Left Array and j is the pointer in the Right Array. 

-> If at any point arr[i] <= 2*arr[j] , we add 1  to the answer as this pair has a contribution to the answer. 

-> If Left Array gets exhausted before Right Array we keep on adding the distance j pointer traveled as both the arrays are Sorted so the next ith element from Left Subarray will equally contribute to the answer.



-> The moment when both Arrays get exhausted we perform a merge operation. This goes on until we get the original array as a Sorted array.

 

Approach :  

-> We first of all call a Merge Sort function, in that we recursively call Left Recursion and Right Recursion after that we call Merge function in order to merge both Left and Right Calls we initially made and compute the final answer.

-> In the Merge function, we will be using low, mid, high values to count the total number of inversion pairs for the Left half and Right half of the Array.

->  Now, after the above task, we need to Merge the both Left and Right sub-arrays using a temporary vector.

-> After this, we need to copy back the temporary vector to the Original Array. Then finally we return the number of pairs we counted.