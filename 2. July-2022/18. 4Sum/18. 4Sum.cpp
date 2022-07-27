class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>>ans;
        set<vector<int>>s1;
        sort(nums.begin(),nums.end());
        for(int i=0;i<nums.size();i++){
            for(int j=i+1;j<nums.size();j++){
                int s=j+1;
                int e=nums.size()-1;
                           
               long long int t=nums[i]+nums[j];
                
               
                    while(s<e){
                        long long int t1= nums[s]+nums[e];
                        long long int rem=t+t1;
                        if(rem==target){
                            vector<int>temp;
                            temp.push_back(nums[i]);
                            temp.push_back(nums[j]);
                            temp.push_back(nums[s]);
                            temp.push_back(nums[e]);
                            if(s1.find(temp)==s1.end()){
                            ans.push_back(temp);
                                s1.insert(temp);
                            }
                            s++,e--;
                            
                        }
                        if(rem>target){
                            e--;
                        }
                        else if(rem<target){
                            s++;
                        }
                    }
                
                
            }
        }
        return ans;
    }
};