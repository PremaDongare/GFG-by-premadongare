import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Integer>> triplets(int[] arr) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        if (arr == null || arr.length < 3) {
            return ans;
        }
        
        Arrays.sort(arr);
        int n = arr.length;
        
        for (int i = 0; i < n - 2; i++) {
            
            // skip duplicate i
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            
            int j = i + 1;
            int k = n - 1;
            
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                
                if (sum == 0) {
                    ans.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k])));
                    
                    j++;
                    k--;
                    
                    // skip duplicate j
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    
                    // skip duplicate k
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
                else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return ans;
    }
}