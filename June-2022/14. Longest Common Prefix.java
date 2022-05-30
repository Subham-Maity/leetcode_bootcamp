class Solution {
    public String longestCommonPrefix(String[] strs) {
        //if empty input, return ""
        if(strs.length == 0){
            return "";
        }
        //assume prefix is first word in the String array
        //go through the rest of words in array
        //remove letter of if there is a letter does not match with letter in prefix
        String prefix = strs[0]; 
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix= prefix.substring(0,prefix.length()-1);
            }
        }
        //if nothing matches with the prefix(first element)we assume, return ""
        if(prefix.length() == 0){
            return "";
        }
        
        return prefix;
    }
}