Brute - Time - O(n^2)  Space O(1)

public int majorityElement(int[] nums){
    int n=nums.length;
   
   for(int i=0;i<nums.length;i++){
      int value=nums[i];
      int count=0;	
   for(int j=0;j<nums.length;j++){
      if(nums[j]==value) count++;
  }
     if(count>n/2) return value;
     }
    return -1; 
}










Better  - Sort - Time - O(nlogn) Space - O(1)


class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        
        int mid = nums.length / 2;
        
        return nums[mid];
    }
}


//same Time - Nlogn + n / O(nlogn) Space - O(1)
class Solution {
public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int num = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num != nums[i]){
                if (counter > n/2){
                    return num;
                }
                num = nums[i];
                counter = 1;
            }
            else {
                counter ++;
            }
        }
        return num;
    }
}





Better  - HashMap - Time - O(n) Space - O(n)


public class Solution {
    public int majorityElement(int[] num) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        if(num.length == 1) return num[0];
        for(int i=0; i<num.length; i++) {
            if(!hm.containsKey(num[i])) {
                hm.put(num[i], 1);
            } else {
                hm.put(num[i], hm.get(num[i])+1);
                if(hm.get(num[i]) > num.length/2) return num[i];
            } 
        }
        return -1;
    }
}





Best(Optimal) - Time - O(n) Space - O(1)

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            // count += (num == candidate) ? 1 : -1; 
            if(num==candidate)
            count += 1; 
            else count -= 1; 
        }

        return candidate;
    }
}


//Same 

class Solution {
    public int majorityElement(int[] nums) {
        int ansIndex = 0;
        int count = 1;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == nums[ansIndex]){
                count++;
            }
            else{
                count--;
            }
                if(count == 0){
                  ansIndex = i;
                  count =1;
                }
        }
        
    int c=0;
    for(int i=0;i<nums.length;i++){
        if(nums[i]==nums[ansIndex]){
            c++;
        }
        if(c>nums.length/2){
            return nums[i];
        }
    }
   return 0;
 }
}


__________________________________________________________
Solution 1 (Brute Force):

Check the count of occurrences of all elements of the array one by one. Start from the first element of the array and count the number of times it occurs in the array. If the count is greater than the floor of N/2 then return that element as the answer. If not, proceed with the next element in the array and repeat the process.

Time Complexity: O(N2) 

Space Complexity: O(1)

Solution 2 (Better):

Intuition: Use a better data structure to reduce the number of look-up operations and hence the time complexity. Moreover, we have been calculating the count of the same element again and again – so we have to reduce that also.

Approach: 

Use a hashmap and store as (key, value) pairs. (Can also use frequency array based on the size of nums) 
Here the key will be the element of the array and the value will be the number of times it occurs. 
Traverse the array and update the value of the key. Simultaneously check if the value is greater than the floor of N/2. 
If yes, return the key 
Else iterate forward.
Time Complexity: O(N)-> Frequency array or O(N log N) -> HashMap 

Space Complexity: O(N)

Solution 3 (Optimal):

Moore’s Voting Algorithm

Intuition: The question clearly states that the nums array has a majority element. Since it has a majority element we can say definitely the count is more than N/2.

Majority element count = N/2 + x;

Minority/Other elements = N/2 – x;

Where x is the number of times it occurs after reaching the minimum value N/2.

Now, we can say that count of minority elements and majority elements are equal up to a certain point of time in the array. So when we traverse through the array we try to keep track of the count of elements and which element we are tracking. Since the majority element appears more than N/2 times, we can say that at some point in array traversal we find the majority element. 

Approach: 

Initialize 2 variables: 
Count –  for tracking the count of element
Element – for which element we are counting
Traverse through nums array.
If Count is 0 then initialize the current traversing integer of array as Element 
If the traversing integer of array and Element are same increase Count by 1
If they are different decrease Count by 1
The integer present in Element is the result we are expecting 


_______________________________________________________________________________________________________________________________________