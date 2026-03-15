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

// creating pair of node and hd to store it in queue
class Pair{
    Node node;
    int hd;
    
    Pair(Node n, int h){
        node = n;
        hd = h;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
    if(root == null) return ans;
    
    // TreeMap to store hd and node 
    TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
    
    Queue<Pair> q = new LinkedList<>();
    q.add(new Pair(root,0)); // add 1st
    
    while(!q.isEmpty()){
        
        //poll first node pair
        Pair p = q.poll();
        Node node = p.node;
        int hd = p.hd;
        
        if(!map.containsKey(hd)){
            map.put(hd, new ArrayList<>());
        }
        
        map.get(hd).add(node.data);
        
        //left
        if(node.left != null)
        q.add(new Pair(node.left, hd -1));
        
        //right
        if(node.right != null)
        q.add(new Pair(node.right, hd+1));
    }
    //add to ans
    for(ArrayList<Integer> list: map.values()){
        ans.add(list);
    }
    return ans;
        
    }
}