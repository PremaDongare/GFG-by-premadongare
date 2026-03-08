class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        // code here
        int n = arr.length;
        
        //find max
        int max =0;
        for(int x:arr){
            if(x>max){
                max=x;
            }
        }
        
        // create boolean arr
        boolean[] present = new boolean[max*max+1];
        
        for(int x:arr){
            present[x*x]=true;
        }
        
        // check all pairs
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int sum = arr[i]*arr[i]+arr[j]*arr[j];
                if(sum <= max*max && present[sum]){
                    return true;
                }
            }
        }
        return false;
    }
}