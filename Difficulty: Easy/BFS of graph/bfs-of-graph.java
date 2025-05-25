class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfstrav = new ArrayList<>();
        int V= adj.size();
        boolean[] visited = new boolean[V];
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int node=queue.poll();
            bfstrav.add(node);
            
            for(int neigh: adj.get(node)){
                if(!visited[neigh]){
                    queue.add(neigh);
                    visited[neigh]= true;
                }
            }
        }
        
        return bfstrav;
    }
}