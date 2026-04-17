#User function Template for python3

class Solution:
    def series(self, n):
        # Code here
        mod= 10**9+7
        
        a,b =0,1
        ans=[]
        
        for i in range (n + 1):
            ans.append(a%mod)
            a,b= b,(a+b)%mod
        return ans;