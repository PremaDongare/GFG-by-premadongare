class Solution {
    // Recursive DFS function to count paths from u to dest
    public int dfs(int u, int dest, List<List<Integer> > adj, int[] dp) {
        // Base Case
        if (u == dest) {
            return 1;
        }


        if (dp[u] != -1) {
            return dp[u];
        }

        int count = 0;

        // Explore all neighbors of current node u
        for (int v : adj.get(u)) {
            count += dfs(v, dest, adj, dp);  // Recursive call to child node v
        }

        
        return dp[u] = count;  
    }
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Step 1: Build adjacency list from edge list
        List<List<Integer> > adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);  
        }

      
        int[] dp = new int[1001];
        Arrays.fill(dp, -1);

       
        return dfs(src, dest, adj, dp);
    }
}
