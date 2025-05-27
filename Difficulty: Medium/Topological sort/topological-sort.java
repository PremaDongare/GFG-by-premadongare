class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v); // Directed edge u → v
        }

        // Step 2: Perform DFS for topological sort
        boolean[] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                topSortUtil(adj, i, vis, s);
            }
        }

        // Step 3: Prepare the result
        ArrayList<Integer> result = new ArrayList<>();
        while(!s.isEmpty()) {
            result.add(s.pop());
        }

        return result;
    }

    // Helper method for DFS
    public static void topSortUtil(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] vis, Stack<Integer> s) {
        vis[curr] = true;

        for(int neighbor : adj.get(curr)) {
            if(!vis[neighbor]) {
                topSortUtil(adj, neighbor, vis, s);
            }
        }

        s.push(curr);
    }
}
