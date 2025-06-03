// User function Template for Java

class Solution {
    int countAtMostK(String s, int k) {
        
        int n=s.length();
        int[] freq = new int[26];
        int i=0, j=0, result=0, distinct=0;
        
        while(j<n){
            
            if(freq[s.charAt(j) - 'a']==0){
                distinct++;
            }
            freq[s.charAt(j)-'a']++;
            
            while(distinct>k){
                freq[s.charAt(i)-'a']--;// shrink
                if(freq[s.charAt(i)-'a']==0){
                    distinct--;
                }
                i++;
            }
            result += j-i+1;
            j++;
        }
        return result;
        
    }
    int countSubstr(String s, int k){
        return countAtMostK(s, k) - countAtMostK(s, k - 1);

    }
}