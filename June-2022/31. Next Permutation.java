

// My Code (video)



class Solution {
  public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}

public void reverse(int[] nums, int i, int j) {
    while(i < j) swap(nums, i++, j--);
}
  
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return; //base case 
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) i--; //traverse backward 
        if(i >= 0) { //if we get the break point                          
            int j = nums.length - 1;              
            while(nums[j] <= nums[i]) j--;  //again iterate find who is greater 
            swap(nums, i, j);//swap                     
        }
        reverse(nums, i + 1, nums.length - 1);    //reverse the righ half   
     } 
}











// Coding Ninja
// https://www.codingninjas.com/codestudio/problems/893046?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution{
public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
  int n = permutation.size();
  if(permutation == null || n<=1) return permutation;
 
   int i = n-2;
   while(i>=0 && permutation.get(i)>=permutation.get(i+1))i--;
 
    if(i>=0){ 
     int j=n-1;
     while(permutation.get(j)<=permutation.get(i))j--;
     Collections.swap(permutation,i,j);
   }
   reverse(permutation,i+1, n-1);
   return permutation;
 }
    
    public static void reverse(ArrayList<Integer> arr, int i, int j){
        while(i<j)Collections.swap(arr,i++,j--);
    }
}