// User function Template for Java

class Solution {
    public int maximumProfit(int prices[]) {
        int n = prices.length;
        int maxrate=0;
        for(int i=0; i<n-1; i++){
            for(int j =i+1; j<n; j++){
               
                 int  maxcount=prices[j]-prices[i];
                  maxrate=Math.max(maxrate,maxcount);
               
            }
        }
       
        return maxrate;
    }
   
    
}