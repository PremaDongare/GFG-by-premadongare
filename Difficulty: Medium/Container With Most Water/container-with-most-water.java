// User function Template for Java

class Solution {

    public int maxWater(int arr[]) {
        // Code Here
        int maxcontainer=0;
        int l=0;
        int r=arr.length-1;
        while(l<r){
            int minarr= Math.min(arr[l], arr[r]);
            int width = (r-l);
            
            int curr = minarr*width;
            maxcontainer = Math.max(maxcontainer, curr);
            
            if(arr[l]<arr[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxcontainer;
        
    }
}