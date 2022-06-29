class Solution {
    public int fib(int N) {
         
        int prv1 = 1;
        int prv2 = 0;
      
      
      if (N == 0){
            return 0;
        }
       
    for(int i = 2; i <= N; i++) {
             int curr = prv1 + prv2;
              prv2 = prv1;
              prv1 = curr;
        }
        return prv1;
    }
}


__________________________________________________


class Solution {
    public int fib(int N) {
        if (N == 0)
            return 0;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}

_______________________________________________________


// Approach 1: Recursion
// Use a recursive algorithm to resolve the problem with no-cache
Time Complexity -  O(2^n)
Space - O(n)


public class FibonacciRecursion {  
    int fibonacci(int i) {
        if (i < 2) return i;
        return fibonacci(i-1) + fibonacci(i-2);
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciRecursion().fibonacci(10));
    }
}
// Output
// 55







// Approach 2: Memoization/Top-down Dynamic Programming
// Using a cache array to store computed results starting from N to 0, so-called top-down
Time Complexity - O(n)
Space - O(n)

public class FibonacciMemoization {  
    int[] dp;

    FibonacciMemoization(int[] dp){
        this.dp = dp;
    }

    int fib(int n) {
        if (dp[n] == 0) {
            if (n < 2) dp[n] = n;
            else dp[n] = fib(n-1) + fib( n-2);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(new FibonacciMemoization(new int[n+1]).fib(n));
    }
}

// Output
// 8








// Approach 3: Tabulation/Bottom-up Dynamic Programming
// Using a cache array to store computed results starting from 0 to N, so-called bottom-up
Time Complexity - O(n)
Space - O(n)


public class Fibonacci{
    public static int fibDP(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public static void main(String[] args){
        System.out.println(fibDP(6));
    }
}


// Output
// 8








// Approach 4: Space optimization Dynamic Programming
Time Complexity - O(n)
Space - O(1)


public class FibonacciMemoization {

    public static int fibDP(int n) {
        int prev1 = 1;
        int prev2 = 0;

        if (n == 0) {
            return 0;
        }

        for (int i = 2; i < n+1; i++) {
            int curr = prev1 + prev2;

            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public static void main(String[] args){
        System.out.println(fibDP(6));
    }
}

// Output
// 8







