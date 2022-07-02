Binary Exponentiation |  Iterative | Recursive | Brute force - 4 Approach in Details


1. brute force, time O(n) TLE

class Solution {
    
    //1. brute force, time O(n) TLE, space O(1)
    public double myPow(double x, int n) {
        long nl = n;
        if(nl<0) {
            nl = -nl;
            x = 1/x;
        }
        
        double result=1;
        while(nl!=0) {
            result = result * x;
            nl--;
        }
        return result;
}





2. recursive, time = O(logn), space = O(logn) (depth is logn)

/**
 * Reduce N by half in every recursion
 *
 * Time Complexity: O(log N)
 *
 * Space Complexity: O(log N) - Space required by recursion stack.
 *
 * N = Input number n.
 */

class Solution {
       public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if(n == Integer.MIN_VALUE){
        x = x * x;
        n = n/2;
        }
        if (n == 0) return 1;
        if (x == 1) return x;
        
        return pow(1, x, n);
    }
    
    double pow(double result, double x, int n) {
        if (n == 0) return result;
        if (n % 2 != 0) result *= x;
        return pow(result, x*=x , n/=2);
    }
}


//Same

    public double myPow(double x, int n) {
        long nl = n;
        if(nl<0) {
            nl = -nl;
            x = 1/x;
        }
        return helper(x,nl);
    }
    
    double helper(double x, long n) {
        if(n==0) return 1;
        double half = helper(x,n/2);
        double result = half * half;
        if(n%2==1)//odd
            result = result * x;
        return result;
    }




3. iterative time = O(logn), space = O(1)

/**
 * Reduce N by half in every iteration.
 *
 * Time Complexity: O(log N)
 *
 * Space Complexity: O(1)
 *
 * N = Input number n.
 */
class Solution {
    public double myPow(double x, int n) {
        long nl = n;
        if(nl<0) {
            nl = -nl;
            x = 1/x;
        }
        double result=1;
        while(nl!=0) {
            if(nl%2==1) 
            result = result * x;
            x=x*x;           
            nl = nl/2;
        }
        return result;
    }
        
}


4. Binary Exponentiation time = O(logn), space = O(1)
    //for example
    //x^9= x^(1001(2)) = x^(2^3 + 2^0) =  x^(2^3) * x^(2^0) 
    //which means you only need to calculate x^(2^3) and x^(2^0)
    
    //time = O(logn) //the length of binaray representaion, space = O(1)
    //it's even faster than the above iterative solution, because it's doing bitwise operations.
class Solution {
          public double myPow(double x, int n) {
        long nl = n;
        if(nl<0) {
            nl = -nl;
            x = 1/x;
        }
          
        double result=1;
        while(nl!=0) {
            if((nl&1)==1) result = result * x; //check the LSB, if it's 1, then multiply x by result
            x=x*x; //keep squaring x
            nl= nl>>1; //right shifting to scan the LSB
        }
        return result;
    }
}