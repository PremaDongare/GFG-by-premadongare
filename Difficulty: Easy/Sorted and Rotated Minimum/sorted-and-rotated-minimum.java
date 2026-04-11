class Solution {
    public int findMin(int[] arr) {
        // code here
        int ans =Integer.MAX_VALUE;
        int l=0;
       int h=arr.length-1;
        
        while(l<= h){
            int mid = l+(h-l)/2;
            
            if(arr[l]<=arr[mid]){
                ans =Math.min(ans,arr[l]);
                l = mid+1;
            }else{
                ans=Math.min(ans, arr[mid]);
                h=mid-1;
            }
        }
        return ans;
    }
}
