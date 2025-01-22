//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().calculateSpan(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to calculate the span of stock's price for all n days.
     public ArrayList<Integer> calculateSpan(int[] stocks) {
        int n = stocks.length;
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while the current price is greater than the price at the index stored at the top of the stack
            while (!s.isEmpty() && stocks[i] >= stocks[s.peek()]) {
                s.pop();
            }

            // If the stack is empty, the span is i+1 (all previous prices are smaller)
            if (s.isEmpty()) {
                span.add(i + 1);
            } else {
                // Otherwise, calculate the span as the difference between the current index and the index at the top of the stack
                span.add(i - s.peek());
            }

            // Push the current index onto the stack
            s.push(i);
        }

        return span;
    }
}