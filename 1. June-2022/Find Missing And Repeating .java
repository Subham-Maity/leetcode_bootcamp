// Brute Force (Use Sorting)
// Approach: 

// Sort the input array.
// Traverse the array and check for missing and repeating.
// Time Complexity: O(nLogn)


// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


class Solve {
    int[] findTwoElement(int arr[], int n) {
       Arrays.sort(arr);
       int res[] = new int[2];
       int sum=0;
       int total=0;
       for(int j=1;j<=n;j++)
       total+=j;  
       
       sum=arr[0]; 
       for(int i=1;i<n;i++)
       {
           if(arr[i]==arr[i-1])
           {
               res[0]=arr[i]; 
           }
           sum+=arr[i]; 
       }
       
       sum=sum-res[0];
       res[1]=total-sum;
       return res;
   }
}






// _________________________________________________________________________________________________________________________________________________________________________________________



//Brute Force(Use a Map)
// Approach: 
// This method involves creating a Hashtable with the help of Map. In this, the elements are mapped to their natural index. In this process, if an element is mapped twice, then it is the repeating element. And if an element’s mapping is not there, then it is the missing element.


// { Driver Code Starts
// Initial Template for Java


class Solve {
    int[] findTwoElement(int arr[], int n) {
       // code here
       HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
       int result[] = new int[2];
       int double_sum =0;
       int real_sum=0;
       for(int i=0;i<n;i++){
           double_sum+=arr[i];
           if(map.containsKey(arr[i])){
               map.put(arr[i],map.get(arr[i])+1);
           }
           else
           map.put(arr[i],1);
       }
       for(int i=0;i<n;i++){
           real_sum+=(i+1);
           if(map.get(arr[i])==2)
           result[0]=arr[i];
       }
       
       double_sum-=result[0];
       result[1] = real_sum - double_sum;
       
       return result;
       
   }
}

// _________________________________________________________________________________________________________________________________________________________________________________________

//GFG

// Solution 3: XOR

// Intuition + Approach: 

// Let x and y be the desired output elements.

// Calculate the XOR of all the array elements.

// xor1 = arr[0]^arr[1]^arr[2]…..arr[n-1]

// XOR the result with all numbers from 1 to n

// xor1 = xor1^1^2^…..^n

// xor1 will have the result as (x^y), as others would get canceled. Since we are doing XOR, we know xor of 1 and 0, is only 1, so all the set bits in xor1, mean that the index bit is only set at x or y.

// So we can take any set bit, in code we have taken the rightmost set bit, iterate over it, and divide the numbers into two hypothetical buckets.

// If we check for numbers with that particular index bit set, we will get a set of numbers that belongs to the first bucket, also we will get another set of numbers belonging to the second bucket. The first bucket will be containing either x or y, similarly, the second bucket will also be containing either x or y. XOR of all elements in the first bucket will give X or Y, and XOR of all elements of the second bucket will give either X or Y since there will be double instances of every number in each bucket except the X or Y.

// We just need to iterate again to check which one is X, and which one is y. Can be simply checked by linear iterations. For a better understanding, you can check the video explanation.




// User function Template for Java

class Solve {
   int[] findTwoElement(int ar[], int n) {
       int xor=0;
       for(int i=0;i<n;i++)
       xor=xor^ar[i]^(i+1);
        
        int m=xor&~(xor-1);//MASK
        int ans1=0;
        for(int i=0;i<n;i++)
        { if((m&(i+1))==0)
          ans1^=(i+1);
          if((m&ar[i])==0)
          ans1^=ar[i];
        }
   //ans1 may be repeating elemnent or unappeared elemnt
        int res[]=new int[2];
        //checking for repeating element
        for(int i=0;i<n;i++)
        {
            if(ans1==ar[i])
            {res[0]=ans1;res[1]=xor^ans1;break;}
             if((ans1^xor)==ar[i])
             {res[0]=ans1^xor;res[1]=ans1;break;}
        }
        return res;
        
   }

}



//Same(another)

static int x, y;
 
    static void getTwoElements(int arr[], int n)
    {
        /* Will hold xor of all elements
       and numbers from 1 to n  */
        int xor1;
 
        /* Will have only single set bit of xor1 */
        int set_bit_no;
 
        int i;
        x = 0;
        y = 0;
 
        xor1 = arr[0];
 
        /* Get the xor of all array elements  */
        for (i = 1; i < n; i++)
            xor1 = xor1 ^ arr[i];
 
        /* XOR the previous result with numbers from
       1 to n*/
        for (i = 1; i <= n; i++)
            xor1 = xor1 ^ i;
 
        /* Get the rightmost set bit in set_bit_no */
        set_bit_no = xor1 & ~(xor1 - 1);
 
        /* Now divide elements into two sets by comparing
    rightmost set bit of xor1 with the bit at the same
    position in each element. Also, get XORs of two
    sets. The two XORs are the output elements. The
    following two for loops serve the purpose */
        for (i = 0; i < n; i++) {
            if ((arr[i] & set_bit_no) != 0)
                /* arr[i] belongs to first set */
                x = x ^ arr[i];
 
            else
                /* arr[i] belongs to second set*/
                y = y ^ arr[i];
        }
        for (i = 1; i <= n; i++) {
            if ((i & set_bit_no) != 0)
                /* i belongs to first set */
                x = x ^ i;
 
            else
                /* i belongs to second set*/
                y = y ^ i;
        }
        
        // at last do a linear check which amont x and y is missing or repeating 
 
        /* *x and *y hold the desired output elements */
    }


//  This method doesn’t cause overflow, but it doesn’t tell which one occurs twice and which one is missing. We can add one more step that checks which one is missing and which one is repeating by iterating over the array. This can be easily done in O(N) time.

// Time Complexity: O(N) 

// Space Complexity: O(1) As we are NOT USING EXTRA SPACE







// ___________________________________________________________________________________________________
// __________________________________________________________________________________________________

// Coding Ninja  https://www.codingninjas.com/codestudio/problems/873366?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=3

// Stack

import java.util.ArrayList;
import java.util.*;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int b[] = new int[2];
         Map<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr.get(i))){
                b[0]=arr.get(i);
            }else {
                map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
            }
        }
        for(int i=1;i<=n;i++){
            if(!map.containsKey(i)){
                b[1]=i;
                break;
            }
        }
        int temp= b[0];
        b[0]=b[1];
        b[1]=temp;
        return b;
    }
}