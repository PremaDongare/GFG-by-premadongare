// User function template for JAVA

class Solution {
    // Function to find all combinations of elements
    
        private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind; i<arr.length; i++){
            if(arr[i]>target) break;
            ds.add(arr[i]);
           findCombinations(i,arr,target-arr[i],ans,ds);// recursion 
           ds.remove(ds.size()-1);// back tracking
        }
    }
   
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
       Arrays.sort(arr);
       List<List<Integer>> ans = new ArrayList<>();
       findCombinations(0,arr,target,ans,new ArrayList<>());
       
       // convert List<List<Integer>> to ArrayList<Integer>
       ArrayList<ArrayList<Integer>> result= new ArrayList<>();
       for(List<Integer> list:ans){
           result.add(new ArrayList<>(list));
       }
        return result;
    }
}