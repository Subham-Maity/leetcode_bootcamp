
Brute - Time - O(n^2) Space - O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Brute Force
        StringBuilder str = new StringBuilder(s);
        if (str.length() == 0) {
            return 0;
        }
        
        int start = 0;
        int max = 1;
        
        for (int i = 1; i < str.length(); i++) {
            for (int j = start; j < i; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    start = j + 1;
                }
            }
            max = i - start + 1 > max ? i - start + 1 : max;
        }
        return max;
    }
}




_________________________________________________________________________________________________________________________________

Better Time - O(2n) Space - O(n)

Algo 

Step 1 -> 0.check char in the set(right) 

Step 2 -> If present -> 1.remove char(left pointers) -> 2.left move(left++) -> 0.check char in the set

Step 3 -> In Not -> 1.find length -> 2.push char(right pointers) -> 3.right move pointer(for loop) -> 0.check char in the set




class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
             return 0;
        int max_length = 0;
        Set < Character > set = new HashSet < > ();
        int left = 0;
        for (int right = 0; right < s.length(); right++) //3.move right pointer
        {
            if (set.contains(s.charAt(right))) //0.check char in the set
            {
                while (left < right && set.contains(s.charAt(right))) {//if present 
                    set.remove(s.charAt(left));//1.remove char 
                    left++;//2.left move 
                }
            }
            max_length = Math.max(max_length, right - left + 1);//1.find length
            set.add(s.charAt(right));//2.push char ->right side
            
            
        }
        return max_length;
    }
}

_________________________________________________________________________________________________________________________________

Optimal Time - O(n) Space - O(n)

Algo 

Step 1 -> 0.check char in the set(right) 

Step 2 -> If present -> 1.left jump(map -> present char's key + 1 -> index position) -> 2.Push char(right) -> 3.length find -> 4.move right pointers

Step 3 -> In Not -> 1.Push char(right) -> 2.length find -> 3.move right pointers




public class Solution {
    public int lengthOfLongestSubstring(String s) {
                HashMap < Character, Integer > map = new HashMap < Character, Integer > ();

        int left = 0, right = 0;
        int n = s.length();
        int max_length = 0;
        while (right < n) {//4.move right pointers
            if (map.containsKey(s.charAt(right))){  //0.check char in the set(right) 
                left = Math.max(map.get(s.charAt(right)) + 1, left); //1.left jump(map -> present char's key + 1 -> index position)
            }


            map.put(s.charAt(right), right);//2.Push char(right)

            max_length = Math.max(max_length, right - left + 1);//3.length find
            right++;
        }
        return max_length;
    }
}