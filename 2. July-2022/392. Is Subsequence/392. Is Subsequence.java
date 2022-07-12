Initialize two pointer to traverse both Strings.
Loop through the bigger string( String t in our case)
compare both string , if equal, then increase both pointers, If not, increase only t_pointer.
If s_pointer length is equal to s.length, that means we have found all the String characters in t. Return true, else return false.


class Solution {

public boolean isSubsequence(String s, String t) {
    if(s.length()==0) return true;
    
    int j=0;
    
    for(int i=0;i<t.length();i++)
    {
        if(s.charAt(j)==t.charAt(i))
        {
            j++;
            if(j==s.length())
                return true;
        }
        
        }
    return false;
   }
}




//Same 

class Solution {
    public boolean isSubsequence(String s, String t) {
        
            if(s.length()==0) return true;
            
             int j = 0;
             for (int i = 0 ; i < t.length() ; i++){
             if (s.charAt(j)== t.charAt(i)) j++;
             if (j==s.length()) return true;
       }
            return false ;
  
  }
}