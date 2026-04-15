class Solution {
    public static String encode(String s) {
        // code here
        StringBuilder ans = new StringBuilder();
        
        int count =1;
        for(int i=1; i<s.length(); i++){
            
            if(s.charAt(i) == s.charAt(i-1)){
                count ++;
            }else{
                ans.append(s.charAt(i-1)).append(count);
                count =1; // reset
            }
        }
        ans.append(s.charAt(s.length()-1)).append(count);
        return ans.toString();
        
        
    }
}