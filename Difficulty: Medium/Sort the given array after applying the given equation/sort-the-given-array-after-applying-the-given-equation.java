//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read the array line and convert to int[]
            String input = br.readLine().trim();
            String[] tokens = input.split("\\s+");
            int n = tokens.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Read a, b, c from separate lines
            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());
            int c = Integer.parseInt(br.readLine().trim());

            // Call the solution method
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.sortArray(arr, a, b, c);

            // Output the result
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int transform(int x, int A, int B, int C){
         return A*x*x+B*x+C;
    }
    public ArrayList<Integer> sortArray(int[] arr, int A, int B, int C) {
      int n=arr.length;
      ArrayList<Integer> result = new ArrayList<>(n);
      int[] temp= new int[n];
      
      int left=0, right=n-1;
      int index=(A>=0) ?n-1: 0;
      
      while(left<=right){
          int leftVal = transform(arr[left],A,B,C);
          int rightVal = transform(arr[right],A,B,C);
          
          if(A>=0){
              if(leftVal > rightVal){
                  temp[index--] = leftVal;
                  left++;
              }else{
                  temp[index--] = rightVal;
                  right--;
              }
              }else{
                  if(leftVal < rightVal){
                      temp[index++] = leftVal;
                      left++;
                  }else{
                      temp[index++] = rightVal;
                      right--;
                  }
              }
          }
          
          for(int val: temp){
              result.add(val);
          }
           return result; 
      }
      
        
    }
    
    
