//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            StringTokenizer stt = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());

            long a[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }

            Solution obj = new Solution();
            out.println(obj.countSubArrayProductLessThanK(a, n, k));

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    public long countSubArrayProductLessThanK(long arr[], int n, long k) {
        if (k <= 1) {
            return 0;
        }

        long prod = 1; // Initialize the product variable
        int start = 0; // Left pointer of the sliding window
        long count = 0; // To count subarrays

        for (int end = 0; end < n; end++) {
            prod *= arr[end]; // Multiply the product with the current element

            // Shrink the window until the product is less than k
            while (prod >= k && start <= end) {
                prod /= arr[start];
                start++;
            }

            // Add all subarrays ending at `end`
            count += (end - start + 1);
        }

        return count;
    }
}