/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    // Function to check whether the list is palindrome.
    static boolean isPalindrome(Node head) {
        // Your code here
        if(head == null || head.next == null) return true;
        
        //step 1 find middle 
        Node slow = head;
        Node fast=head;
        
        while(fast != null && fast.next != null){
            slow= slow.next;
            fast=fast.next.next;
        }
        
        // step2 reverse second half
        Node secondHalf= reverse(slow);
        Node firstHalf= head;
        
        //step3 Compare halve
        
        while(secondHalf!= null){
            if(firstHalf.data != secondHalf.data) return false;
            firstHalf=firstHalf.next;
            secondHalf= secondHalf.next;
        }
        
        return true;
        
        
    }
    
    static Node reverse(Node head){
        Node prev = null;
        while(head!= null){
            Node next = head.next;
            head.next = prev;
            prev=head;
            head = next;
        }
        
        return prev;
    }
}