//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
       if (!s.isEmpty()) {
            // Remove the top element
            int x = s.pop();
            
            // Sort remaining stack
            sort(s);
            
            // Insert the top element in sorted position
            insertSorted(s, x);
        }
        return s;
    }
    
    // Recursive function to insert an element in sorted position
    private void insertSorted(Stack<Integer> s, int x) {
        // If stack is empty or top element is less than x
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        
        // If x is less than the top element
        // Remove the top element
        int temp = s.pop();
        
        // Recursively insert x
        insertSorted(s, x);
        
        // Put back the top element
        s.push(temp);
    }
}