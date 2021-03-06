/*class Solution {
    public int[] twoSum(int[] nums, int target) {
    

            for ( int i = 0; i<nums.length; i++){ // iterate from first to last index 
                for (int j = i + 1; j < nums.length; j++ ) {// second for loop for match the pair 
                    int main = target - nums[i] ;//store here target[9] - [2....15] example suppose 9-7 = 2 and 9-2 = 7 
                    
                 if ( nums[j] == main ){//now comapare the element 2 and 7 with the second loop what is running 
                     return new int[]{i , j};//return 
                 }
                
            }
    }
    
    throw new IllegalArgumentException("Not present ");
}

}*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
      
        int index[] = new int[2];//output
            for (int i = 0; i< nums.length; i++){
                int current = nums[i]; //2..15
                
                
                for ( int j =i+1 ; j<nums.length ; j++){
                    if (current + nums[j] == target) {//2+7 = 9
                       index[0] = i;
                       index[1] = j;
                        
                        
                    }
                    
                }
            }
        return index;
     
    }
}






//optimal


class Solution {

  public int[] twoSum(int[] nums, int target) {
// Create a HashMap
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {

      // Get the complement using the target value
      int complement = target - nums[i];

      // Search the hashmap for complement, if found, we got our pair
      if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
      }

      // Put the element in hashmap for subsequent searches.
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }
}