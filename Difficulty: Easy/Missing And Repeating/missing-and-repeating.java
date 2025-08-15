class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n = arr.length;
        int [] hash = new int [n+1];
        
        for(int i=0; i<n; i++){
            hash[arr[i]]++;
        }
        
        int repet = -1, missing=-1;
        for(int i=1; i<=n;i++){
            if(hash[i] == 2) repet = i;
            else if(hash[i] ==0) missing = i;
            
            if(repet !=-1 && missing!= -1)
            break;
        }
       ArrayList<Integer> ans = new ArrayList<>();
        ans.add(repet);
        ans.add(missing);
        return ans;
    }
}
