Brute - 

public boolean isIsomorphic(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
    
        for(Integer i = 0; i < s1.length(); i++) {

            if(m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }





My Solution- 

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s==null || t == null) return false;
        if(s.length() != t.length()) return false;
            
            Map<Character,Integer> maps = new HashMap<Character,Integer>();
            Map<Character,Integer> mapt = new HashMap<Character,Integer>();
            
            for ( int i = 0; i< s.length(); i++){
                    int indexs = maps.getOrDefault(s.charAt(i),-1);
                    int indext = mapt.getOrDefault(t.charAt(i),-1);
                    
                    if (indexs != indext) {
                            return false;
                    }
                    
                    maps.put(s.charAt(i),i);
                    mapt.put(t.charAt(i),i);
                            
            }
            return true;
    }
}




Another Type -


public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                 if(map.get(a).equals(b))
                continue;
                else
                return false;
            }else{
                if(!map.containsValue(b))
                map.put(a,b);
                else return false;
                
            }
        }
        return true;
        
    }
}