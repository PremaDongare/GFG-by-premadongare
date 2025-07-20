// User function Template for Java

class Solution {
    
    public static void substring(int idx, int [] nums, ArrayList<ArrayList<Integer>> result, List<Integer> ds ){
        result.add(new ArrayList<>(ds));
        
        for(int i=idx; i<nums.length; i++){
            if(i!=idx && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);// ading
            
            substring(i+1, nums, result, ds); // recursion
            
            ds.remove(ds.size()-1); // backtrack
            
            
        }
    }
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        substring(0, nums, result, new ArrayList<>());
        return result;
    }
}