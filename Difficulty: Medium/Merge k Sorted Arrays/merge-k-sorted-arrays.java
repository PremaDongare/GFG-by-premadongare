class Solution {
    // Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
       ArrayList<Integer> result = new ArrayList<>();
       
       for(int i=0; i<k;i++){
           for(int j=0; j<k; j++){
               result.add(arr[i][j]);
           }
       }
       
       Collections.sort(result);
       return result;
    }
}