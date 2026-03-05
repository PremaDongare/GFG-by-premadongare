class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int i=0, j=0;
        int maxlen=-1;
        int [] freq = new int[26];
        int distinctchar = 0;
        int n = s.length();
        
        while(j<n){
            int index = s.charAt(j)-'a';
            
            if(freq[index] ==0)
            distinctchar ++;
            
            freq[index]++;
            
            while(distinctchar > k){
                int leftIndex = s.charAt(i)- 'a';
                freq[leftIndex]--;
                
                if(freq[leftIndex]==0)
                distinctchar --;
                i++;
            }
            
            if(distinctchar == k){
               maxlen = Math.max(maxlen, j-i+1);
            }
            j++;
        }
        return maxlen;
    }
}