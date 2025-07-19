// User function template for JAVA

class Solution {
    // Function to find all combinations of elements
    
    private static void findcombinnations (int ind, int[]arr, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer>ds){
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=ind; i<arr.length; i++){
            // skip duplicates
            if(i >ind && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            ds.add(arr[i]);
             findcombinnations(i+1, arr ,target-arr[i],ans, ds); // recursion
             ds.remove(ds.size()-1);// backtrack
             
        
        }
        
        
    }
    // in array arr that sum to target.
    static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        // add your code here
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans= new ArrayList<>();
        findcombinnations(0,arr,target,ans,new ArrayList<>());
         
         return ans;
    }
    
}