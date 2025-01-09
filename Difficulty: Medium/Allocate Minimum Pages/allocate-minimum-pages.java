//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    
    public static int findPages(int[] arr, int k) {
        if(k>arr.length){
            return -1;
        }
        int low = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            low = Math.max(low,arr[i]);
        }
        int high = 0;
        for(int i=0; i<arr.length; i++){
            high +=arr[i];
        }
        int result= -1;
        
        
        // BINARY SEARCH
        while(low <= high){
            int mid =low+(high-low)/2;
            
            if(isPossible(arr, k, mid)){
                result =mid;
                high = mid-1; // try for the smaller max
            }else{
                low = mid+1;   // increase the maximum allocation
            }
        }
       return result;
}
          private static boolean isPossible(int [] arr, int k, int maxPages){
              int student =1;
              int pagesum =0;
              for (int i=0; i<arr.length; i++){
                  if(pagesum+arr[i] > maxPages){
                      student ++; // assign new student
                      pagesum = arr[i]; // start a new allocation
                      
                      // if the number of student exceed
                      if(student>k) return false;
                      
                  }else{
                      pagesum+=arr[i];
                  }
              }
              return true;
              
          }
}
         