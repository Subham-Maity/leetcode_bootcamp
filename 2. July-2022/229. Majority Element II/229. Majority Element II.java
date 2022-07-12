Brute - T- O(n^2)  S- O(1)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]) > nums.length/3 && !list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        return list;
    }
}



better - Sort - T- O(nLogn)  S- (1)

class Solution {
       public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int currCount = 1;
        int i=1;
        for(;i<nums.length;i++){
            if(nums[i-1]==nums[i])
                currCount++;
            else{
                if(currCount>nums.length/3)
                     result.add(nums[i-1]);
                currCount = 1;
            }
        }
        if(currCount>nums.length/3)
            result.add(nums[i-1]);
        
        return result;
    }
    }



    better - HashMap - T- O(n)  S- O(n)

    class Solution {
    public List<Integer> majorityElement(int[] nums) {
   
        HashMap<Integer,Integer> hm=new HashMap<>();
        for (int e:nums){
            if(!hm.containsKey(e)){
               hm.put(e,1);
            }else {
                hm.put(e,hm.get(e)+1);
            }
        }
      
        List<Integer> list=new ArrayList<>();
        for (Map.Entry<Integer,Integer> m:hm.entrySet()){
            if(m.getValue()> nums.length/3 ){
                list.add(m.getKey());
            }
        }
        return list;
    }
}




Best - Extended Boyer Moore’s Voting Algorithm - T- O(n)  S- O(1)


class Solution {
    public List<Integer> majorityElement(int[] nums) {

    int candidate = 0, candidate2 = 0, count1 = 0, count2 = 0;
     for (int num : nums) {
      if (num == candidate)
        count1++;
      else if (num == candidate2)
        count2++;
      else if (count1 == 0) {
        candidate = num;
        count1 = 1;
      } else if (count2 == 0) {
        candidate2 = num;
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }
    ArrayList < Integer > ans = new ArrayList < Integer > ();
    count1 = 0;
    count2 = 0;
    for (int num : nums) {
      if (num == candidate)
        count1++;
      else if (num == candidate2)
        count2++;
    }
    if (count1 > nums.length / 3)
      ans.add(candidate);
    if (count2 > nums.length / 3)
      ans.add(candidate2);
    return ans;
  }
}


//Same 

class Solution {
    public List<Integer> majorityElement(int[] nums) {

       int number1 = -1, number2 = -1, count1 = 0, count2 = 0, len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] == number1)
        count1++;
      else if (nums[i] == number2)
        count2++;
      else if (count1 == 0) {
        number1 = nums[i];
        count1 = 1;
      } else if (count2 == 0) {
        number2 = nums[i];
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }
    ArrayList < Integer > ans = new ArrayList < Integer > ();
    count1 = 0;
    count2 = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] == number1)
        count1++;
      else if (nums[i] == number2)
        count2++;
    }
    if (count1 > len / 3)
      ans.add(number1);
    if (count2 > len / 3)
      ans.add(number2);
    return ans;
  }
}
   