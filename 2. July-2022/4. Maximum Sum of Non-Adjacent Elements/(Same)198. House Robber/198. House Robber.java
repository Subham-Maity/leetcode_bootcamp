// RECURSIVE(TIME LIMIT EXCEEDED)
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        return f(n-1,nums);
        
    }
    public int f(int ind,int nums[])
    {
        if(ind==0)
            return nums[ind];
        else if(ind<0)
            return 0;
        int pick=nums[ind]+f(ind-2,nums);
        int notpick=f(ind-1,nums);
        return Math.max(pick,notpick);
        
    }
}
// 2.MEMOIZATION(TOP-DOWN DP,RECURSIVE DP (ACCEPTED))

class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return f(n-1,nums,dp);
        
    }
    public int f(int ind,int nums[],int dp[])
    {
        if(ind==0)
            return nums[ind];
        else if(ind<0)
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        int pick=nums[ind]+f(ind-2,nums,dp);
        int notpick=f(ind-1,nums,dp);
        return dp[ind]=Math.max(pick,notpick);
        
    }
}
// 3.ITERATIVE DP(BOTTOM-UP)

class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return f(nums,dp);
        
    }
    public int f(int nums[],int dp[])
    {
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int pick=nums[i];
            if(i>1)
                pick+=dp[i-2];
            int notpick=dp[i-1];
            dp[i]=Math.max(pick,notpick);
        }
        return dp[nums.length-1];
    }
}
// 4.SPACE OPTIMIZATION

class Solution {
    public int rob(int[] nums) {
        
        int n=nums.length;
        return f(nums);
        
    }
    public int f(int nums[])
    {
        int prev=nums[0];
        int prev2=0;
        int curr=0;
        for(int i=1;i<nums.length;i++)
        {
            int pick=nums[i];
            if(i>1)
                pick+=prev2;
            int notpick=prev;
            curr=Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}