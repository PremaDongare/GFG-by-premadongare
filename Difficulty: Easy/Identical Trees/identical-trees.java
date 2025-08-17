/*
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}*/

class Solution {
    boolean isIdentical(Node r1, Node r2) {
        // using DFS
        if(r1 == null && r2 == null){
            return true;
        }
        if(r1==null || r2 == null){
            return false;
        }
        return (r1.data == r2.data) &&
        isIdentical(r1.left, r2.left) &&
        isIdentical(r1.right, r2.right);
    }
}