/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Node curr = root;
        
        while(curr != null){
            
            if(curr.left == null){
                result.add(curr.data);
                curr= curr.right;
            }else{
                Node pre = curr.left;
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;
                }
                if(pre.right == null){
                    // create thread to root
                    pre.right = curr;
                    curr= curr.left;
                }else{
                    //remove thread 
                    pre.right = null;
                    result.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}