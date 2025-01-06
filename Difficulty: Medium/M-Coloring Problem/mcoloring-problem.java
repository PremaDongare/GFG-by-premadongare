//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Check if it's safe to color a node with the given color
    private static boolean isSafe(int node, List<List<Integer>> adj, int[] color, int col) {
        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == col) return false; // Adjacent node has the same color
        }
        return true;
    }

    // Backtracking function to solve the graph coloring problem
    private static boolean solve(int node, int v, List<List<Integer>> adj, int m, int[] color) {
        if (node == v) return true; // All nodes are colored
        
        // Try all colors for the current node
        for (int col = 1; col <= m; col++) {
            if (isSafe(node, adj, color, col)) {
                color[node] = col; // Assign color
                if (solve(node + 1, v, adj, m, color)) return true; // Solve for the next node
                color[node] = 0; // Backtrack
            }
        }
        return false; // No valid color found
    }

    boolean graphColoring(int v, List<int[]> edges, int m) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Assuming undirected graph
        }

        // Initialize colors array
        int[] color = new int[v];
        Arrays.fill(color, 0); // 0 means no color assigned

        // Start backtracking from node 0
        return solve(0, v, adj, m, color);
    }
}
