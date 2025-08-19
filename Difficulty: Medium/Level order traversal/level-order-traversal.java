/*
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        if(root==null) return result;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size(); //  number of nodes at current level 
            ArrayList<Integer> level = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                Node curr= queue.poll();
                level.add(curr.data);
                
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            result.add(level);
            
        }
        return result;
    }
}