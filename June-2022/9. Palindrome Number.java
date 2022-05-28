class Solution {
    public boolean isPalindrome(int x) {
        if ( x == 0) //corner case zero is palindrome number 
        {
            return true;
        }
        
        if (x<0 || x % 10 == 0 && x!=0)
        {
            return false;
        }
        int rvrs = 0; //default 
      
      
        while(x > rvrs){
            int cur = x % 10;//last digit 
             
             x /= 10; //12
          
          rvrs = (rvrs*10)+cur;
          
        }
      
      return (x==rvrs || x == rvrs/10);
     
    }
}