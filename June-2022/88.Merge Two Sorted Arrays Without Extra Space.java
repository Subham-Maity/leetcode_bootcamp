 /*  Brute Force - 

    Time complexity: O((M+N) * log(M+N))
    Space complexity: O(1)

 Intuition: We can use a new array of size n+m and put all elements of arr1 and arr2 in it, and sort it. After sorting it, but all the elements in arr1 and arr2.

Approach:

Make an arr3 of size n+m.
Put elements arr1 and arr2 in arr3.
Sort the arr3.
Now first fill the arr1 and then fill remaining elements in arr2. 
*/


import java.util.*;

public class CodeXam {

  public static void main(String[] args) {
    int arr1[] = {1,4,7,8,10};
    int arr2[] = {2,3,9};
    System.out.println("Before merge:");
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }
    System.out.println();
    merge(arr1, arr2, arr1.length, arr2.length);
    System.out.println("After merge:");
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }

  }
  static void merge(int[] arr1, int arr2[], int n, int m) {
    int arr3[] = new int[n + m];
    int k = 0;
    for (int i = 0; i < n; i++) {
      arr3[k++] = arr1[i];
    }
    for (int i = 0; i < m; i++) {
      arr3[k++] = arr2[i];
    }
    Arrays.sort(arr3);
    k = 0;
    for (int i = 0; i < n; i++) {
      arr1[i] = arr3[k++];
    }
    for (int i = 0; i < m; i++) {
      arr2[i] = arr3[k++];
    }

  }
}



// Coding Ninja(Brute Force) : https://www.codingninjas.com/codestudio/problems/1214628?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=2

import java.util.Arrays;

public class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {

        for (int i = 0; i < n; i++) {
            arr1[i + m] = arr2[i];
        }

        Arrays.sort(arr1);
        return arr1;

    }
}



// __________________________________________________________________________________________________________________________________________________
// __________________________________________________________________________________
// __________________________________________________________________________________________________________________________________________________



 /*   better - Gap Method or Shell Short Intuition
 
    Time complexity: -O(n+m)log(n+m)                 
    Space complexity: O(1)

    Approach:

Initially take the gap as (m+n)/2;
Take as a pointer1 = 0 and pointer2 = gap.
Run a oop from pointer1 &  pointer2 to  m+n and whenever arr[pointer2]<arr[pointer1], just swap those.
After completion of the loop reduce the gap as gap=gap/2.
Repeat the process until gap>0.
*/


public class CodeXam {

  public static void main(String[] args) {
    int arr1[] = {1,4,7,8,10};
    int arr2[] = {2,3,9};
    System.out.println("Before merge:");
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }
    System.out.println();
    merge(arr1, arr2, arr1.length, arr2.length);
    System.out.println("After merge:");
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }

  }
  static void merge(int[] arr1, int arr2[], int n, int m) {
    // code here
    int i, k;
    for (i = 0; i < n; i++) {
      // take first element from arr1 
      // compare it with first element of second array
      // if condition match, then swap
      if (arr1[i] > arr2[0]) {
        int temp = arr1[i];
        arr1[i] = arr2[0];
        arr2[0] = temp;
      }

      // then sort the second array
      // put the element in its correct position
      // so that next cycle can swap elements correctly
      int first = arr2[0];
      // insertion sort is used here
      for (k = 1; k < m && arr2[k] < first; k++) {
        arr2[k - 1] = arr2[k];
      }
      arr2[k - 1] = first;
    }
  }
}



// GFG(Shell Sort) : https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            long arr1[] = new long[n];
            long arr2[] = new long[m];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr1[i] = Long.parseLong(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for(int i=0; i<m; i++){
                arr2[i] = Long.parseLong(inputLine[i]);
            }
            Solution ob = new Solution();
            ob.merge(arr1, arr2, n, m);
            
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr1[i]+" ");
            }
            for(int i=0; i<m; i++){
                str.append(arr2[i]+" ");
            }
            System.out.println(str);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
   public static void merge(long a[], long b[], int n, int m) {
       int gap = (n+m+1)/2;
       int i=0;
       while(gap>0){
           while(i+gap<n+m){
               if(i<n && i+gap<n){
                   if(a[i]>a[i+gap]) swap(a, i, i+gap);
               }else if(i<n && i+gap>=n){
                   if(a[i]>b[i+gap-n]) swap(a, b, i, i+gap-n);
               }else if(i>=n){
                   if(b[i-n]>b[i+gap-n]) swap(b, i-n, i-n+gap);
               }
               i++;
           }
           if(gap==1) break;
           gap = (gap+1)/2;
           i=0;
       }
   }
   
   static void swap(long a[], int i, int j){
       long temp = a[i];
       a[i] = a[j];
       a[j] = temp;
   }
   
   static void swap(long a[], long b[], int i, int j){
       long temp = a[i];
       a[i] = b[j];
       b[j] = temp;
   }
}




// LeetCode(Shell Sort) : https://leetcode.com/problems/merge-sorted-array/
class Solution {

    public void swap(int[] arr, int l, int r) {//swap two elements in an array
        int temp = arr[l]; //temp is the left element
        arr[l] = arr[r];//left element is now the right element
        arr[r] = temp;//right element is now the left element
    }
    public void merge(int[] arr1, int m, int[] arr2, int n) {//merge two arrays function
        int z = 0; //z is the index of the first array
        for (int i = m; i < m + n; i++) // Inserting elements of arr2 at ending of arr1
            arr1[i] = arr2[z++];//incrementing z to point to the next element of arr2 and assigning it to arr1 


        //*Taking gap=m as till that elements are already sorted*
        for (int gap = m; gap >= 1; gap /= 2) {
            for (int j = gap; j < m + n; j++) { 
                int k = j - gap; //k is the index of the first element of the subarray
                while (k >= 0 && arr1[k + gap] < arr1[k]) {//loop to sort the array using the gap 
                    swap(arr1, k + gap, k);//swap the elements at the index k and k+gap 
                    k = k - gap;//decrementing k to point to the next element of the subarray 
                }
            }
        }
    }
}





// __________________________________________________________________________________________________________________________________________________
// __________________________________________________________________________________
// __________________________________________________________________________________________________________________________________________________

/*   better - insertion sort
 
    Time complexity: -O(n*m)              
    Space complexity: O(1)

 Intuition: We can think of Iterating in arr1 and whenever we encounter an element that is greater than the first element of arr2, just swap it. Now rearrange the arr2 in a sorted manner, after completion of the loop we will get elements of both the arrays in non-decreasing order.

Approach:

Use a for loop in arr1.
Whenever we get any element in arr1 which is greater than the first element of arr2,swap it.
Rearrange arr2.
Repeat the process.
*/

public class CodeXam {

  public static void main(String[] args) {
    int arr1[] = {1,4,7,8,10};
    int arr2[] = {2,3,9};
    System.out.println("Before merge:");
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }
    System.out.println();
    merge(arr1, arr2, arr1.length, arr2.length);
    System.out.println("After merge:");
    for (int i = 0; i < arr1.length; i++) {
      System.out.print(arr1[i] + " ");
    }
    System.out.println();
    for (int i = 0; i < arr2.length; i++) {
      System.out.print(arr2[i] + " ");
    }

  }
  static void merge(int[] arr1, int arr2[], int n, int m) {
    // code here
    int i, k;
    for (i = 0; i < n; i++) {
      // take first element from arr1 
      // compare it with first element of second array
      // if condition match, then swap
      if (arr1[i] > arr2[0]) {
        int temp = arr1[i];
        arr1[i] = arr2[0];
        arr2[0] = temp;
      }

      // then sort the second array
      // put the element in its correct position
      // so that next cycle can swap elements correctly
      int first = arr2[0];
      // insertion sort is used here
      for (k = 1; k < m && arr2[k] < first; k++) {
        arr2[k - 1] = arr2[k];
      }
      arr2[k - 1] = first;
    }
  }
}



// LeetCode(insertion sort) : https://leetcode.com/problems/merge-sorted-array/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<nums2.length;i++)
            insert(i,nums1,nums2);
    }
    
    static void insert(int i,int[] nums1,int[] nums2)
    {
        int index=nums1.length-(nums2.length-i)-1;
        while(index>=0&&nums2[i]<nums1[index])
        {
            nums1[index+1]=nums1[index];
            index--;
        }
        nums1[index+1]=nums2[i];
    }
}




// __________________________________________________________________________________________________________________________________________________
// __________________________________________________________________________________
// __________________________________________________________________________________________________________________________________________________

