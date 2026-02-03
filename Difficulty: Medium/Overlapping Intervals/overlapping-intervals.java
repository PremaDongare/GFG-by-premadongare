class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        ArrayList<int[]> result = new ArrayList<>();
        if(arr.length == 0){
            return result ;
        }
        
        Arrays.sort(arr, (a,b)-> a[0]- b[0]);
        
        
        int[] newinterval = arr[0];
        result.add(newinterval);
        
        for(int[] interval: arr){
            
            if(interval[0] <= newinterval[1]){
                newinterval[1] = Math.max(newinterval[1], interval[1]);
               
            }
            
            else{
                newinterval = interval;
                result.add(newinterval);
            }
            
        }
        return result;
        
    }
}