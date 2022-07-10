# Approach 1: Using Separate Space
Intuition

We are required to find the running sum of numbers nums[i] in the input array where i ranges from 0 to n-1 and n is the size of the input array. We can see that the running sum is the sum of all of the elements from index 0 to index i inclusive. Since we start building our output array at index 0, at each index i we have already calculated the sum of all numbers up to and including index i-1. Thus, instead of recalculating the sum, we can get the result for index i by simply adding the element at index i to the previously calculated running sum for index i-1.

## Algorithm

Define an array result.
Initialize the first element of result with the first element of the input array.
At index i append the sum of the element nums[i] and previous running sum result[i - 1] to the result array.
We repeat step 3 for all indices from 1 to n-1.

### java
```java
class Solution {
public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];//initialize result array with length of nums array

        // Initialize first element of result array with first element in nums.
        result[0] = nums[0];
        // Append the sum of the element nums[i] and previous running sum result[i - 1] to the result array.
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }
}
```
### C++
```cpp
class Solution {
public:
    vector<int> runningSum(vector<int> &nums) {
        // Initialize result array with first element in nums.
        vector<int> result = {nums[0]};

        for (int i = 1; i < nums.size(); i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            result.push_back(result.back() + nums[i]);
        }
        return result;
    }
};

```
### Python
```python
class Solution(object):
    def runningSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = [nums[0]]
        for i in range(1, len(nums)):
            result.append(result[i - 1] + nums[i])
        return result
```

## Complexity Analysis

Time complexity: O(n) where n is the length of the input array. This is because we use a single loop that iterates over the entire array to calculate the running sum.

Space complexity: O(1) since we don't use any additional space to find the running sum. Note that we do not take into consideration the space occupied by the output array.

# Approach 2: Using Input Array for Output
Intuition

In the previous approach we created an extra array to store our results. However, we do not actually need to do so. We can obtain the same result without using extra space by performing the same operations on the input array instead.

## Algorithm

Increase nums[i] by the previous index's running sum. The previous index's running sum is stored at index i-1 in the input array.
We repeat step 1 for all indices from 1 to n-1.

### Java 

```java
class Solution {
    class Solution {
        public int[] runningSum(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                // Result at index `i` is sum of result at `i-1` and element at `i`.
                nums[i] += nums[i - 1];
            }
            return nums;
        }
    }  
}

```
### C++

```cpp
class Solution {
public:
    vector<int> runningSum(vector<int> &nums) {
        for (int i = 1; i < nums.size(); i++) {
            // Result at index `i` is sum of result at `i-1` and element at `i`.
            nums[i] += nums[i - 1];
        }
        return nums;
    }
};
```
### Python

```python

class Solution(object):
    def runningSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        for i in range(1, len(nums)):
            nums[i] += nums[i - 1]
        return nums
```

Complexity Analysis

Time complexity: O(n)where nn is the length of input array.

Space complexity: O(1)since we don't use any additional space to find the running sum. Note that we do not take into consideration the space occupied by the output array.