Brute 
T- O(N log N + N³ logN)
S - O(M * 4)

class Solution {
    int[] nums;
    public int bin_search(int low, int high , int target){
        int mid;
        while(low<=high && low >=0 && high < nums.length){
            mid = (low+high)/2;
            if(nums[mid]== target){
                return mid;
            }
            if(nums[mid] < target){
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        this.nums = nums;
        List<List<Integer>> four_sums =  new ArrayList<List<Integer>>();
        for(int i=0; i< nums.length-3; i++){
            for(int j=i+1; j< nums.length-2; j++){
                for(int k=j+1; k< nums.length-1 ;k++){
                    int search_ele = nums[i]+nums[j]+nums[k];
                    search_ele = target-search_ele;
                  // Binary search for the fourth element 
                    if(bin_search(k+1, nums.length-1, search_ele ) !=-1){
                        List<Integer> quads = new ArrayList<Integer>();
                        quads.add(nums[i]);
                        quads.add(nums[j]);
                        quads.add(nums[k]);
                        quads.add(search_ele);
                        if(!four_sums.contains(quads)){
                            four_sums.add(quads);    
                        }
                        
                    }
                }
            }
        }
        return four_sums;
    }
}





Optimal 
T- O(n^3)
S- O(1)

class Solution {
    //TC --> O(N^3) || SC --> O(1);
        
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> set = new ArrayList<>();
        Arrays.sort(nums); //O(NlogN)
        int N = nums.length;
        
        if(nums == null || N == 0) return set;
        
        for(int i=0; i<N; i++) { //O(N)
            long target1 = target - nums[i];
            for(int j=i+1; j<N; j++) { //O(N)
                long target2 = target1 - nums[j];
                
                int left = j+1, right = N-1;
                    
                while(left < right) { //O(N)
                    
                    long remSum = (long)nums[left] + (long)nums[right];
                    
                    if(remSum < target2) {
                        left++;
                    }
                    else if(remSum > target2) {
                        right--;
                    }
                    else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        set.add(quad);
                        
//to get unique quad --> we need to skip duplicates for - left and right pointers
                            
                        while(left < right && nums[left] == quad.get(2)) ++left;
                        
                        while(left < right && nums[right] == quad.get(3)) --right;
                    }
                }
                //removing duplicates for j th element
                    
                while(j+1 < N && nums[j+1] == nums[j]) ++j;
            }
            //removing duplicates for i th element
            while(i+1 < N && nums[i+1] == nums[i]) ++i;
        }
        return set;
    }
}