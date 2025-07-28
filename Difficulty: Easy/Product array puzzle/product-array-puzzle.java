// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int n = arr.length;
        int [] result = new int [n];
        result[0]=1;
        
        // left
        for(int i=1; i<n; i++){
            result[i]=result[i-1]*arr[i-1];
        }
        // right 
       int  right=1;
        for(int i=n-1; i>=0; i--){
            result[i]= result[i] * right;
            right*=arr[i];
        }
        return result;
    }
    
}
