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
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node pre = null;
        Node suc = null;
        Node curr = root;
        
        while (curr != null){
            
            // possible pre
            if (key > curr.data){
                pre = curr;
                curr = curr.right;
            }//possible suc
            else if(key < curr.data){
                suc = curr;
                curr = curr.left;
            }else { // max from left 
                if(curr.left != null){
                    Node temp = curr.left;
                    while(temp.right != null){
                        temp = temp.right;
                    }
                    pre = temp;
                }
                
                // min from right
                if(curr.right != null){
                    Node temp = curr.right;
                    while(temp.left != null){
                        temp= temp.left;
                    }
                    suc = temp;
                }
                break;
            }
        }
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(pre);
        ans.add(suc);
        
        return ans;
        
    }
}