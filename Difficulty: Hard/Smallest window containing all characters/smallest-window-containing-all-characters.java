class Solution {
    public static String minWindow(String s, String p) {
        // code here
        int [] freq = new int [26];
        for(char c : p.toCharArray()){
            freq[c - 'a']++;
        }
        int l=0,count =p.length();
        int minlen = Integer.MAX_VALUE;
        int start =0;
        
        for(int r=0; r<s.length(); r++){
            if(freq[s.charAt(r)-'a']>0){
                count --;
            }
            
            freq[s.charAt(r)-'a']--;
            
            // minimize the wind 
            while(count == 0){
                if(r-l+1 < minlen){
                    minlen = r-l+1;
                    start =l;
                }
                
                freq[s.charAt(l)-'a']++;
                
                if(freq[s.charAt(l) - 'a'] >0){
                    count ++;
                }
                l++;
            }
        }
         if(minlen == Integer.MAX_VALUE) return "";
        
        return s.substring(start, start + minlen);
    }
}