Time Complexity: O(N), where N is the length of nums.

Space Complexity: O(1), the space used by leftsum and S.

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        
        for(int i=0;i < nums.length;i++) {
            sum += nums[i];
        }
        
        int lsum = 0;
        int rsum = sum;
        
        for(int i=0; i < nums.length;i++) {
            rsum = rsum - nums[i];
            
            if(lsum == rsum) {
                return i;
            }
            
            lsum += nums[i];
        }
        
        return -1;
    }
}


//Same



class Solution {
   public int pivotIndex(int[] nums) {
      int sum = 0;

      for (int i = 0; i < nums.length; i++) {
         sum += nums[i];
      }

      int lsum = 0;
      int rsum = sum;

      for (int i = 0; i < nums.length; i++) {
         rsum = rsum - nums[i];

         if (lsum == rsum) {
            return i;
         }

         lsum += nums[i];
      }

      return -1;
   }
}

//Same

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
            
        for (int i = 0; i < nums.length; i++) 
             
                sum = sum + nums[i];
            
        for (int i = 0; i < nums.length; i++) {
                
            if (leftsum == sum - leftsum - nums[i]) 
              
                    return i;
            
                leftsum += nums[i];
        }
        return -1;
    }
}



//Same 
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}