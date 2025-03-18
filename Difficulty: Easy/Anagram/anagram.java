//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s, String t) {
          if(s.length() != t.length()){
              return false;
          }
          
          HashMap<Character, Integer> map = new HashMap<>();
          for(int i=0; i<s.length(); i++){
              char ch = s.charAt(i);
              map.put(ch, map.getOrDefault(ch, 0)+1);
          }
          for(int i=0; i<t.length(); i++){
              char ch= t.charAt(i);
              if(map.get(ch) != null){
                  if(map.get(ch) == 1){
                      map.remove(ch);
                  }else{
                      map.put(ch,map.get(ch)-1);
                  }
              }else{
                  return false;
              }
          }
              
              return map.isEmpty();
          }
        
    }