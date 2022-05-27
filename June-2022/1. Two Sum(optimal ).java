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