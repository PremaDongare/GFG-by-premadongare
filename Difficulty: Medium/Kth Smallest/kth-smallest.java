// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        
        // first count the max num in our array
        int max =0;
        for(int num: arr){
            if(num > max) max=num;
        }
        // now count there frequency 
        int [] freq = new int [max+1];
        for(int num : arr){
            freq[num]++;
        }
        
        int count =0;
        for(int i=0; i<= max; i++){
            count += freq[i];
            if(count >=k) return i;
        }
        
       return -1; 
    }
}
