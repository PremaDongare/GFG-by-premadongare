// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        // Write your code here
        Stack<Node> s= new Stack<>();
        Node curr = root;
        
        while(curr!=null || !s.isEmpty()){
            //left
            
            while(curr!=null){
                s.push(curr);
                curr= curr.left;
            }
            //pop
            curr = s.pop();
            k--;
            if(k==0) return curr.data;
            
            //right 
            curr = curr.right;
            
        }
        //if k is not correct
        return -1;
    }
}