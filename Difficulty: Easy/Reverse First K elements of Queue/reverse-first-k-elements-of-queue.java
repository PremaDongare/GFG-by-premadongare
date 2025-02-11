//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class ModifyQueue {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Taking count of total number of elements
            int n = sc.nextInt();

            // Taking count of total elements
            // that need to be reversed
            int k = sc.nextInt();

            // Creating a Queue
            Queue<Integer> q = new LinkedList<>();

            // adding all the elements to the Queue
            while (n-- > 0) {
                q.add((int)sc.nextInt());
            }

            // Creating an object of class GfG
            GfG g = new GfG();

            // calling modifyQueue of class GfG
            // and passing Queue and k as arguments
            // and storing the reuslt in a new Queue
            Queue<Integer> ans = g.modifyQueue(q, k);

            // Printing all the elements from the
            // new Queue and polling them out
            while (!ans.isEmpty()) {
                int a = ans.peek();
                ans.poll();
                System.out.print(a + " ");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        if (q.isEmpty() || k > q.size() || k <= 0) 
            return q;
        
        // Use deque for O(1) operations at both ends
        Deque<Integer> deque = new ArrayDeque<>();
        
        // Step 1: Store first k elements in deque
        int count = k;
        while (count > 0) {
            deque.addFirst(q.poll());
            count--;
        }
        
        // Step 2: Add elements back to original queue
        while (!deque.isEmpty()) {
            q.add(deque.poll());
        }
        
        // Step 3: Rotate remaining elements
        count = q.size() - k;
        while (count > 0) {
            q.add(q.poll());
            count--;
        }
        
        return q;
    }
}