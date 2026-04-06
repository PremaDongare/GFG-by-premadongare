class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer, Integer>freq = new HashMap<>();
        freq.put(0,1);
        
        int prefix =0;
        int count =0;
        
        for(int num: arr){
            prefix ^= num;
            
            int target = prefix ^ k;
            
            if(freq.containsKey(target)){
                count += freq.get(target);
            }
            
            freq.put(prefix , freq.getOrDefault(prefix,0)+1);
        }
        
        return count;
    }
}