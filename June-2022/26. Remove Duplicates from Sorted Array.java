//1st solution(bruteforce)

class Solution {
    public int removeDuplicates(int[] nums) {
          
        HashSet < Integer > set = new HashSet < > ();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x: set) {
            nums[j++] = x;
        }
        return k;
    }
}
 

//___________________________________________________________________________________


//2nd solution (optimal) 

class Solution {
    public int removeDuplicates(int[] nums) {
      int l = 0;
      
      for ( int k = 1 ;k < nums.length; k++){
        
        if (nums[l] != nums[k]){
          
          l++;
          nums[l] = nums[k];

      }
        
    }
  
  return l+1;
  
}

}




