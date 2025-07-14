// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        // sliding window
        int left =0 , right=0;
        int maxcount =0;
        
        Set <Character> set = new HashSet<>();
        
        while(right < s.length()){
            char curr = s.charAt(right);
            
            while(set.contains(curr)){
                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(curr);
            maxcount= Math.max(maxcount, right-left+1);
            right ++;
            
            
        }
        return maxcount;
    }
}