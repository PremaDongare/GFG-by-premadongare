/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    Node buildTree(int[] inorder, int[] postorder) {
        // code here
        if(inorder == null || postorder == null || inorder.length != postorder.length )
        return null;
        
        HashMap<Integer, Integer> hm= new HashMap<Integer, Integer>();
        
        for(int i=0; i<inorder.length; i++)
        hm.put(inorder[i],i);
        
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder,0,postorder.length-1,hm);
        
    }
    
    private Node buildTreePostIn(int[] inorder, int is, int ie,
                                      int[] postorder, int ps, int pe,
                                       HashMap<Integer, Integer> hm){
                                           
    if(ps>pe || is>ie) return null;
    
    Node root = new Node(postorder[pe]);
    int inRoot = hm.get(postorder[pe]);
    int numsLeft = inRoot -is;
    root.left=buildTreePostIn(inorder, is, inRoot-1, postorder, ps,ps+numsLeft-1,hm);
    root.right = buildTreePostIn(inorder,  inRoot+1,ie, postorder ,ps+numsLeft,pe-1,hm);
    return root;
                                       }
}