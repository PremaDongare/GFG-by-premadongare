/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int count =0;
    public int countAllPaths(Node root, int k) {
        // code here
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L,1);
        
        dfs(root, 0, k, map);
        return count;
        
    }
    void dfs(Node node, long sum, int k, HashMap<Long, Integer> map){
        if(node == null) return;
        
        sum += node.data;
        if(map.containsKey(sum-k)){
            count += map.get(sum-k);
        }
        
        map.put(sum, map.getOrDefault(sum,0)+1);
        
        dfs(node.left, sum, k, map);
        dfs(node.right, sum, k, map);
        
        map.put(sum, map.get(sum)-1);//backtrack
    }
}