// Here shows 3 Approaches to slove this problem: Sort, Priority Queue, Quick Sort.




// Sort
// Sort the array first, then the k-th element.

// Time Complexity: O(nlogn).
// Space Complexity: O(logn).

class Solution {
    public int findKthLargest(int[] nums, int k) {
      int len = nums.length;        
      Arrays.sort(nums);
      return nums[len - k];
    }
}









// ___________________
// ___________________
// ___________________
// ___________________
// ___________________
// ___________________
// ___________________
// ___________________




// Priority Queue

// Time Complexity: O(nlogk).
// Space Complexity: O(k).



class Solution {
    public int findKthLargest(int[] nums, int k) {
   PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (pq.peek()<nums[i]) {
                
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }
}



// Same(Another)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num: nums){
            heap.offer(num);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}



// ___________________
// ___________________
// ___________________
// ___________________
// ___________________
// ___________________
// ___________________
// ___________________



// Divide and Conquer

// Time Complexity: O(n).
// Space Complexity: O(1).

/*Algo

function quickSelect(list, left, right, k)

   if left = right
      return list[left]

   Select a pivotIndex between left and right

   pivotIndex := partition(list, left, right, 
                                  pivotIndex)
   if k = pivotIndex
      return list[k]
   else if k < pivotIndex
      right := pivotIndex - 1
   else
      left := pivotIndex + 1*/

class Solution 
{
    public int findKthLargest(int[] nums, int k) 
    {
        return find(0, nums.length-1, nums, k-1);
    }
    
    private int find(int low, int high, int[] nums, int index)
    {
        if(high <= low) return nums[low];
        int pivot = nums[high];//high 
        int pointer = low;//pointer 
        for(int i = low; i < high; i++)
            if(nums[i] >= pivot) swap(pointer++, i, nums);
        swap(pointer, high, nums);
        if(pointer == index) return nums[pointer];
        else if(pointer > index) return find(low, pointer-1, nums, index);
        else return find(pointer+1, high, nums, index);
    }
    
    private void swap(int i, int j, int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

































//Another Type

class Solution {
    public Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;

        int pointer = 0;
        int right = len - 1;

        while (true) {
            int pivotIndex = partition(nums, pointer, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                pointer = pivotIndex + 1;
            } else {
                // pivotIndex > target
                right = pivotIndex - 1;
            }
        }
    }

    public int partition(int[] nums, int pointer, int right) {
        int randomIndex = pointer + random.nextInt(right - pointer + 1);
        swap(nums, pointer, randomIndex);

        // all in nums[pointer + 1..le) <= pivot;
        // all in nums(ge..right] >= pivot;
        int pivot = nums[pointer];
        int le = pointer + 1;
        int ge = right;

        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }

            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }

            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }

        swap(nums, pointer, ge);
        return ge;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
