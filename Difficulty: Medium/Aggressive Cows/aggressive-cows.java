class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        
        // binary search
        Arrays.sort(stalls);
        int l=0;
        int h= stalls[stalls.length-1]-stalls[0];
        int ans =0;
        
        while(l<=h){
            int mid = l+(h-l)/2;
            // if placement is possible 
            if(canplace(stalls,k,mid)){
                ans = mid;
                l=mid+1;
            }else{
                h=mid-1;
            }
        }
        return ans;
    }
        // code here
        public boolean canplace(int[] stalls, int k, int d){
            int count =1;
            int last = stalls[0];
            for(int i=1; i<stalls.length; i++){
                if(stalls[i] -last >= d){
                    count++;
                    last = stalls[i];
                    if(count >= k)
                    return true;
                }
            }
            return false;
        }
    
    
    
}