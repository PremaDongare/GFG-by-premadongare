// User function Template for Java

class Solution {
    // Function to check if we can reach the last index from the 0th index.
    public boolean canReach(int[] arr) {
        // code here
        int maxcount =0;
        
        for(int i=0; i<arr.length; i++){
            if(i >maxcount){
                return false;
            }
            
            maxcount= Math.max(maxcount, i+arr[i]);
            
            if(maxcount >= arr.length-1){
                return true;
            }
        }
        return false;
    }
}