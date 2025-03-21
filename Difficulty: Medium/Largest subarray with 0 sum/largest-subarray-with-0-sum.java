//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            // Read input array as a string, split by space, and convert to integers
            String[] str = br.readLine().trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Print the result from maxLen function
            System.out.println(new Solution().maxLen(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    int maxLen(int arr[]) {
        // HashMap to store prefix sum and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int maxLength = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            // Case 1: If sum == 0, the subarray from 0 to j has sum 0
            if (sum == 0) {
                maxLength = j + 1;
            }

            // Case 2: If sum is seen before, update maxLength
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, j - map.get(sum));
            } else {
                // Store the first occurrence of the sum
                map.put(sum, j);
            }
        }

        return maxLength;
    }
}