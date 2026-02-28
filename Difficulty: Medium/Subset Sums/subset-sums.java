// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] nums) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        solve(0,0,nums,result);
        return result;
        
    }
    public void solve(int index, int currsum, int [] nums, ArrayList<Integer>result){
        //base
        if(index == nums.length){
            result.add(currsum);
            return;
        }
        
        // pick
        solve(index+1, currsum+nums[index], nums, result);
        //backtrack
        solve(index+1, currsum, nums,result);
    }
}