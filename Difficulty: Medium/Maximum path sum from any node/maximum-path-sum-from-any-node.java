/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int maxsum;
    
    private int solve(Node root){
        if(root == null){
            return 0;
        }
        
        int left=solve(root.left);
        int right = solve(root.right);
        
        int ansfindindounsidetree = left+right+root.data; // case 1
        int anyoneside= Math.max(left,right)+root.data; //case 2
        int onlyRootisvalid=root.data;//case3
        
        maxsum = Math.max(maxsum,Math.max(ansfindindounsidetree, Math.max(anyoneside, onlyRootisvalid)));
        // most important part
        
        return Math.max(anyoneside,onlyRootisvalid);
        
        
    }
    int findMaxSum(Node root) {
        // your code goes here
        maxsum = Integer.MIN_VALUE;
        solve(root);
        return maxsum;
    }
}