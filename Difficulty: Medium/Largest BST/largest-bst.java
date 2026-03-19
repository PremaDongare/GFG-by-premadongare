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

  class Info{
      int min, max, size;
      boolean isBST;
      
      Info(int min, int max, int size, boolean isBST){
          this.min=min;
          this.max = max;
          this.size = size;
          this.isBST = isBST;
      }
  }
  
  int maxsize =0;
     int largestBst(Node root) {
        solve(root);
        return maxsize;
        
    }
    private Info solve(Node root){
        if(root == null){
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        Info left = solve(root.left);
        Info right = solve(root.right);
        
        //check bst condition
        if(left.isBST && right.isBST && root.data > left.max && root.data < right.min){
            int size = left.size + right.size+1;
            maxsize = Math.max(maxsize, size);
            
            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);
            return new Info(min, max, size, true);
        }
        return new Info(0, 0, Math.max(left.size, right.size), false);
    }
}