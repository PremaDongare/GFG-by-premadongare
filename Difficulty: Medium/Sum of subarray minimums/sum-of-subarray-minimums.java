class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int n = arr.length;
        int []left = new int[n];
        int []right= new int[n];
        
        Stack<Integer> stack=new Stack<>();
        
        //left smaller no
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty())
            left[i] = i+1;
            else
            left[i] = i-stack.peek();
            stack.push(i);
        }
        stack.clear();
        
        //right smaller element
        for(int i=n-1; i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty())
            right[i]=n-i;
            else
            right[i]=stack.peek()-i;
            stack.push(i);
        }
        int sum=0;
        for(int i=0; i<n; i++){
            sum+= arr[i] *left[i]*right[i];
        }
        return sum;
        
    }
}
