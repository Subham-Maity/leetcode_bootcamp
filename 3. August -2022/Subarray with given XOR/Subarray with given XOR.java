Brute 


import java.io.*;
public class Solution {
    public int solve(int[] A, int B) {
        int totalCount=0;
        for(int i=0;i<A.length;i++){
            int current_xor = 0;
            for(int j=i;j<A.length;j++){
                current_xor^=A[j];
                if(current_xor==B) totalCount++;
            }
        }
        return totalCount;
    }
}
class CodeXam {
	public static void main (String[] args) {
		Solution obj = new Solution();
		int[] A = new int[]{4,2,2,6,4};
		int countTotal=obj.solve(A,6);
		System.out.println("The total number of subarrays having a given XOR k is "+countTotal);
	}
}











Optimal


import java.io.*;
import java.util.*;
public class Solution {
    public int solve(int[] A, int B) {
     HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>(); 
        int count = 0; 
        int tx = 0;
        int n = A.length;
        for(int i = 0;i<n;i++) {
            tx = tx ^ A[i]; 
            if(visited.get(tx^B) != null) 
                count += visited.get(tx ^ B); 
            if(tx == B) {
                count++; 
            }
            if(visited.get(tx) != null) 
                visited.put(tx, visited.get(tx) + 1); 
            else 
                visited.put(tx, 1); 
        }
        return count; 
    }
}

class CodeXam {
    public static void main (String[] args) {
        Solution obj = new Solution();
        int[] A = new int[]{4,2,2,6,4};
        int countTotal=obj.solve(A,6);
        System.out.println("The total number of subarrays having a given XOR k is "+countTotal);
    }
}