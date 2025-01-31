//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
       int n = val.size();
        double[][] ratio = new double[n][2];

        for (int i = 0; i < n; i++) {
            ratio[i][0] = i; // Store index
            ratio[i][1] = val.get(i) / (double) wt.get(i); // Value-to-weight ratio
        }

        // Sort in descending order based on value-to-weight ratio
        Arrays.sort(ratio, (a, b) -> Double.compare(b[1], a[1]));

        double finalVal = 0.0;

        // Process the items
        for (int i = 0; i < n; i++) {
            int idx = (int) ratio[i][0];

            if (capacity >= wt.get(idx)) { // Include full item
                finalVal += val.get(idx);
                capacity -= wt.get(idx);
            } else { // Include fractional item
                finalVal += ratio[i][1] * capacity;
                break;
            }
        }
        return finalVal;
    }
}
    
    
    
    
    
    
    