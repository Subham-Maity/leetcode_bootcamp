
// Using Recursion 

int solveRec(vector<int>nums , int x)
{
//     Base Case
    if(x == 0) return 0;
    if(x < 0) return INT_MAX;
    
//     Recursive case
    
    int mini = INT_MAX;
    
    for(int i = 0; i < nums.size(); ++i)
    {
        int ans = solveRec(nums , x-nums[i]);
        if(ans != INT_MAX)
        {
            mini = min(mini , ans+1);
        }
    }
    return mini;
}
int minimumElements(vector<int> &num, int x)
{
   
    int ans = solveRec(num , x);
    if(ans == INT_MAX) return -1;
    else return ans;
    
}




___________________________________________________________________


//Using Memorization / Top down

int solveMem(vector<int> &num , int x , vector<int>&dp)
{

    if(x == 0) 
        return 0;
    if(x < 0) 
        return INT_MAX;
    
    if(dp[x] != -1) 
        return dp[x];

    
    int mini = INT_MAX;
    
    for(int i = 0; i < num.size(); ++i)
    {
        int ans = solveMem(num , x-num[i] , dp);
        if(ans != INT_MAX)
        mini = min(mini , ans+1);
        
    }

    dp[x] = mini;
    
    return mini;
}


int minimumElements(vector<int> &num, int x)
{
    vector<int>dp(x+1 , -1);
    int ans = solveMem(num , x , dp);
    if(ans == INT_MAX) 
        return -1;
    else
        return ans;
}


___________________________________________________________________

// Tabulation / Bottom -Up


int solveTab(vector<int>nums , int x)

{
    vector<int>dp(x+1 , INT_MAX);
    int mini = 0;
    dp[0] = 0;
    
    for(int i =1 ; i <= x; ++i)
    {
        for(int j = 0; j < nums.size(); ++j)
        {
            if(i-nums[j] >= 0 && dp[i - nums[j]] != INT_MAX)
            dp[i] = min(dp[i] , 1 + dp[i - nums[j]]);
        }
    }
    
    if(dp[x] != INT_MAX)return dp[x];
    return -1;
                                       
                                       
    
}

int minimumElements(vector<int> &num, int x)
{
    return solveTab(num , x);
}





