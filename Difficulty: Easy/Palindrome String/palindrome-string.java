class Solution {
    boolean isPalindrome(String s) {
        // code here
        
        if(s==null || s.length()==0){
            return true;
        }
        
        int i=0;
        int j=s.length()-1;
        
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
        
    }
}