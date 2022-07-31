Solution 1: Brute Force

// Time complexity: O(n^3)
// Space complexity: O(1)

private boolean arrayContains(int[] arr, int num) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == num) {
            return true;
        }
    }

    return false;
}

public int longestConsecutive(int[] nums) {
    int longestStreak = 0;

    for (int num : nums) {
        int currentNum = num;
        int currentStreak = 1;

        while (arrayContains(nums, currentNum + 1)) {
            currentNum += 1;
            currentStreak += 1;
        }

        longestStreak = Math.max(longestStreak, currentStreak);
    }

    return longestStreak;
}

Solution 2: Using Sorting

// Time complexity: O(n log n)
// Space complexity: O(1)

public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }

    Arrays.sort(nums);

    int longestStreak = 1;
    int currentStreak = 1;

    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i-1]) {
            if (nums[i] == nums[i-1]+1) {
                currentStreak += 1;
            }
            
            else {
                longestStreak = Math.max(longestStreak, currentStreak);
                currentStreak = 1;
            }
        }
    }

    return Math.max(longestStreak, currentStreak);
}


Solution 3: Using HashSet

// Time complexity: O(n)
// Space complexity: O(n)

public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    
    for (int num : nums) {
        set.add(num);
    }

    int longestStreak = 0;

    for (int num : set) {
        if (!set.contains(num - 1)) {
            int currentNum = num;
            int currentStreak = 1;

            while (set.contains(currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }
    }

    return longestStreak;
}


Solution 4: Using HashSet - Optimized

// Time complexity: O(n)
// Space complexity: O(n)

public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    
    for(int n : nums) {
        set.add(n);
    }
    
    int longestStreak = 0;
    
    for(int currNum : set) {
        if(!set.contains(currNum - 1)) {  
            int nextNum = currNum + 1;
            
            while(set.contains(nextNum)) {
                nextNum++;
            }
            
            longestStreak = Math.max(longestStreak, nextNum - currNum);
        }
    }
    
    return longestStreak;
}





With DriverCode for IDE -

Brute

public class CodeXam {
 private static boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }

        return false;
    }

    public static int longestConsecutive(int[] nums) {
        int longestStreak = 0;

        for (int num : nums) {
            int currentNum = num;
            int currentStreak = 1;

            while (arrayContains(nums, currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }

    public static void main(String args[])
    {
        int arr[]={100,200,1,2,3,4};
        int lon=longestConsecutive(arr);
        System.out.println("The longest consecutive sequence is "+lon);

    }
}