class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n= arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1; i>=0; i--){
            // pop element smaller thn curr
            while(!stack.isEmpty() && stack.peek()<= arr[i]){
                stack.pop();
            }
            
            // if stack is empty 
           result.add(0, stack.isEmpty() ? -1 : stack.peek());
            stack.push(arr[i]);
        }
        return result;
    }
}