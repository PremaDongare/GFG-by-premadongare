class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int n = arr.length;
        int i=0,j=0;
        int currxor =0;
        int maxxor=0;
        
        while(j<n){
            currxor ^= arr[j];
            
            // window < k
            if(j-i+1 <k){
                j++;
            }
            //wind size == k
            else if(j-i+1 ==k){
                maxxor = Math.max(maxxor, currxor);
                
                //shrink window 
                currxor ^= arr[i];
                i++;
                j++;
            }
        }
        return maxxor;
        
    }
}
