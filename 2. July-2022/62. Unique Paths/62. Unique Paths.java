Brute(Recursion) - 
Time - O(2^(m+n))
Space - O(2^(m+n))

public int func(int i,int j,int m,int n) {
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n)return 0;
        return func(i+1, j , m , n) + func(i , j+1 , m ,n)








Memorization - bottom-right 
Time - O(mxn)
Space - O(mxn)

class Solution {
public int uniquePaths(int m, int n) {
      int[][] dp = new int[m+1][n+1];
       return rec_uniq(dp, m, n, 0, 0);

}

public int rec_uniq(int[][] dp, int m, int n, int i, int j) {
    //Base case
    if(i == m-1 && j == n-1) return 1;
    if(i >= m || j >= n) return 0;
    
    if(dp[i][j] > 0) {
    return dp[i][j];
    }
    
    return dp[i][j] = rec_uniq(dp, m, n, i+1, j) + rec_uniq(dp, m, n, i, j+1);
    
    
   }
}





//Same - reverse-left up

class Solution {
      public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return helper(m,n,dp);
    }

    static int helper(int m, int n,int[][]dp){
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if (m==1 || n==1){
            return 1;
        }
        dp[m][n] = helper(m-1,  n,dp) +helper(m,  n-1,dp);
        return dp[m][n];
    }
}








// Tabulation
Time - O(mxn)
Space - O(mxn)

class Solution {
public int uniquePaths(int m, int n) {
    int[][] tab = new int[m][n];
    
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            if(i==0 || j==0){
                tab[i][j] = 1;
            }
            else{
                tab[i][j] = tab[i-1][j]+tab[i][j-1];
            }
        }
    }
    
    return tab[m-1][n-1];
   }
}









//Combination
Time - O(m-1) or O(n-1)
Space - O(1)

class Solution {

    public int uniquePaths(int m, int n) {
        int N = (m-1) + (n-1);
        int r = m-1;

        double res = 1;
        for(int i=1; i<=r; i++){
            res = res* (N - r + i)/i; 
        }
        
        return (int) res;
    }
}