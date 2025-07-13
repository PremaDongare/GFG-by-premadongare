class Solution {
    boolean isPalindrome(String s) {
        
        if(s==null || s.length() == 0){
            return true;
        }
        // code here
        Stack <Character> st= new Stack<>();
        for(int i=0; i<s.length();i++){
            st.push(s.charAt(i));
        }
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != st.pop()){
                return false;
            }
        }
        
        return true;
        
    }
    
}